package com.merrymeals.mealsonwheels.Controller;

import com.merrymeals.mealsonwheels.Entity.Funds;
import com.merrymeals.mealsonwheels.Repository.FundsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funds")
public class FundsController {

    @Autowired
    private FundsRepository fundsRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Funds>> getAllFunds() {
        List<Funds> allFunds = fundsRepository.findAll();
        return new ResponseEntity<>(allFunds, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createFunds(@RequestBody Funds funds) {
        funds.setDateTime(LocalDateTime.now());
        Funds createdFunds = fundsRepository.save(funds);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Donation added");
        response.put("name", createdFunds.getName());
        response.put("amount", createdFunds.getAmount());
        response.put("dateTime", createdFunds.getDateTime());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Funds> updateFunds(@PathVariable Long id, @RequestBody Funds funds) {
        Funds existingFunds = fundsRepository.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (existingFunds == null) {
            response.put("message", "Donation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingFunds.setName(funds.getName());
        existingFunds.setAmount(funds.getAmount());
        existingFunds.setDateTime(funds.getDateTime());
        response.put("message", "Donation updated");
        Funds updatedFunds = fundsRepository.save(existingFunds);
        return new ResponseEntity<>(updatedFunds, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFunds(@PathVariable Long id) {
        Funds existingFunds = fundsRepository.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (existingFunds == null) {
            response.put("message", "Donation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fundsRepository.delete(existingFunds);
        response.put("message", "Donation deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
