package com.example.elimdekilerbackend.controller;

import com.example.elimdekilerbackend.model.FoodRecipes;
import com.example.elimdekilerbackend.service.FoodRecipesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/food-recipes")
public class FoodRecipesController {
    private FoodRecipesService foodRecipesService;

    public FoodRecipesController(FoodRecipesService foodRecipesService) {
        this.foodRecipesService = foodRecipesService;
    }

    @PostMapping()
    public ResponseEntity<FoodRecipes> saveFoodRecipes(@RequestBody FoodRecipes foodRecipes){
        return new ResponseEntity<FoodRecipes>(foodRecipesService.saveFood(foodRecipes), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<FoodRecipes> getAllFoodRecipes(){
        return foodRecipesService.getAllFoodRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodRecipes> getFoodRecipesById(@PathVariable("id") long id){
    return new ResponseEntity<>(foodRecipesService.getFoodRecipesById(id), HttpStatus.OK);
    }

    @GetMapping("/rand")
    public List<FoodRecipes> getRandomlyRecipes() {
       return foodRecipesService.getRandomlyRecipes();
    }

    @GetMapping("/ingredients/{ingredients}")
    public List<FoodRecipes> getFoodRecipesByIngredients(@PathVariable("ingredients") List<String> ingredients) {
        return foodRecipesService.getFoodRecipesByIngredients(ingredients);
    }

}
