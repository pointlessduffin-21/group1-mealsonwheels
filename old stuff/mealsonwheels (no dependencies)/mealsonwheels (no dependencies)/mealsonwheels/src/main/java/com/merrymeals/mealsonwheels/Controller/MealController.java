package com.merrymeals.mealsonwheels.Controller;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable Long id) {
        return mealRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal) {
        return mealRepository.save(meal);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        return mealRepository.findById(id)
                .map(existingMeal -> {
                    existingMeal.setMeal_name(meal.getMeal_name());
                    existingMeal.setIngredients(meal.getIngredients());
                    existingMeal.setNutrition(meal.getNutrition());
                    existingMeal.setP_id(meal.getP_id());
                    return ResponseEntity.ok(mealRepository.save(existingMeal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Object> deleteMeal(@PathVariable Long id) {
        return mealRepository.findById(id)
                .map(existingMeal -> {
                    mealRepository.delete(existingMeal);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
