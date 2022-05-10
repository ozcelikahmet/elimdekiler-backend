package com.example.elimdekilerbackend.service;

import com.example.elimdekilerbackend.model.FoodRecipes;

import java.util.List;

public interface FoodRecipesService {
    FoodRecipes saveFood(FoodRecipes foodRecipes);
    List<FoodRecipes> getAllFoodRecipes();
    List<FoodRecipes> getRandomlyRecipes();
    List<FoodRecipes> getFoodRecipesByIngredients(List<String> ingredients);
    FoodRecipes getFoodRecipesById(long id);
}
