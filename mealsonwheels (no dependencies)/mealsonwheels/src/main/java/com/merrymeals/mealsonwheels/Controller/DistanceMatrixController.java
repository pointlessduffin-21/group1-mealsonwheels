package com.merrymeals.mealsonwheels.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/distance")
public class DistanceMatrixController {
    private final String API_KEY = "AIzaSyBKwt4NuTqH__0QG_rq7MYeVFCNnvX4tVc";

    @GetMapping("/{origin}/{destination}")
    public Object getDistance(@PathVariable String origin, @PathVariable String destination) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + origin + "&destinations=" + destination + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(responseEntity.getBody());
                int distance = root.path("rows").path(0).path("elements").path(0).path("distance").path("value").asInt();
                String originAddress = root.path("origin_addresses").path(0).asText();
                String destinationAddress = root.path("destination_addresses").path(0).asText();

                if (distance < 10000) {     // Less than 10 KM
                    Map<String, Object> response = new HashMap<>();
                    response.put("From", originAddress);
                    response.put("To", destinationAddress);
                    response.put("Status", "Food will be hot");
                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
                    return response;
                } else {                    // More than 10 KM
                    Map<String, Object> response = new HashMap<>();
                    response.put("From", originAddress);
                    response.put("To", destinationAddress);
                    response.put("Status", "Food will be cold");
                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
                    return response;
                }
            } catch (Exception e) {
                return "Error parsing distance. Plese try again later." + e;
            }
        } else {
            return "Error retrieving distance. Please try again later.";
        }
    }
}
