package com.example.elimdekilerbackend.service.impl;

import com.example.elimdekilerbackend.exception.FoodNotFoundException;
import com.example.elimdekilerbackend.model.FoodRecipes;
import com.example.elimdekilerbackend.repository.FoodRecipesRepository;
import com.example.elimdekilerbackend.service.FoodRecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FoodRecipesServiceImpl implements FoodRecipesService {

    private FoodRecipesRepository foodRecipesRepository;

    public FoodRecipesServiceImpl(FoodRecipesRepository foodRecipesRepository) {
        this.foodRecipesRepository = foodRecipesRepository;
    }

    @Override
    public FoodRecipes saveFood(FoodRecipes foodRecipes) {
        return foodRecipesRepository.save(foodRecipes);
    }

    @Override
    public List<FoodRecipes> getAllFoodRecipes() {
        return foodRecipesRepository.findAll();
    }

    @Override
    public List<FoodRecipes> getRandomlyRecipes() {
        List<FoodRecipes> randomlyFoodRecipes= foodRecipesRepository.findAll();
        ArrayList<FoodRecipes> randFoodRecipes = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<6; i++){
            int randNum=rand.nextInt(randomlyFoodRecipes.size());
            if(randFoodRecipes.contains(randomlyFoodRecipes.get(randNum))){
                while (randFoodRecipes.contains(randomlyFoodRecipes.get(randNum))){
                    randNum=rand.nextInt(randomlyFoodRecipes.size());
                }
                randFoodRecipes.add(randomlyFoodRecipes.get(randNum));
            }
            else {
                randFoodRecipes.add(randomlyFoodRecipes.get(randNum));
            }

        }
        return randFoodRecipes;

    }

    @Override
    public List<FoodRecipes> getFoodRecipesByIngredients(List<String> ingredients) {
        List<FoodRecipes> foodRecipes= foodRecipesRepository.findAll();
        ArrayList<FoodRecipes> foodRecipesByIngredients = new ArrayList<>();
        for(FoodRecipes foodRecipe : foodRecipes){
            int allIngredients=0;
            for(int i=0;i<ingredients.size();i++) {
                if (foodRecipe.getIngredients().contains(ingredients.get(i))) {
                    allIngredients++;
                }
            }
            if(allIngredients == ingredients.size())
            foodRecipesByIngredients.add(foodRecipe);

        }
        if(foodRecipesByIngredients.size() > 3){
            return foodRecipesByIngredients.subList(0,3);
        }
        else{
            return foodRecipesByIngredients;
        }

    }

    @Override
    public FoodRecipes getFoodRecipesById(long id) {
        Optional<FoodRecipes> foodRecipes = foodRecipesRepository.findById(id);
        if(foodRecipes.isPresent()){
            return foodRecipes.get();
        }else{
            throw new FoodNotFoundException("FoodRecipes", "Id", id);
        }
    }
}
