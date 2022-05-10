package com.example.elimdekilerbackend.service;

import com.example.elimdekilerbackend.model.FoodRecipes;
import com.example.elimdekilerbackend.model.PersonalCareRecipes;

import java.util.List;

public interface PersonalCareRecipesService {
    PersonalCareRecipes savePersonalCare(PersonalCareRecipes personalCareRecipes);
    List<PersonalCareRecipes> getAllPersonalCareRecipes();
    List<PersonalCareRecipes> getRandomlyRecipes();
    List<PersonalCareRecipes> getPersonalCareByIngredients(List<String> ingredients);
    PersonalCareRecipes getPersonalCareRecipesById(long id);
}
