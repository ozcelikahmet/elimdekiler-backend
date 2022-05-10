package com.example.elimdekilerbackend.service.impl;

import com.example.elimdekilerbackend.exception.FoodNotFoundException;
import com.example.elimdekilerbackend.model.FoodRecipes;
import com.example.elimdekilerbackend.model.PersonalCareRecipes;
import com.example.elimdekilerbackend.repository.PersonalCareRecipesRepo;
import com.example.elimdekilerbackend.service.PersonalCareRecipesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PersonalCareRecipesServiceImpl implements PersonalCareRecipesService {

    private PersonalCareRecipesRepo personalCareRecipesRepo;

    public PersonalCareRecipesServiceImpl(PersonalCareRecipesRepo personalCareRecipesRepo) {
        this.personalCareRecipesRepo = personalCareRecipesRepo;
    }

    @Override
    public PersonalCareRecipes savePersonalCare(PersonalCareRecipes personalCareRecipes) {
        return personalCareRecipesRepo.save(personalCareRecipes);
    }

    @Override
    public List<PersonalCareRecipes> getAllPersonalCareRecipes() {
        return personalCareRecipesRepo.findAll();
    }

    @Override
    public List<PersonalCareRecipes> getRandomlyRecipes() {
        List<PersonalCareRecipes> randomlyPersonalCareRecipes= personalCareRecipesRepo.findAll();
        ArrayList<PersonalCareRecipes> randPersonalCareRecipes = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<6; i++){
            int randNum=rand.nextInt(randomlyPersonalCareRecipes.size());
            if(randPersonalCareRecipes.contains(randomlyPersonalCareRecipes.get(randNum))){
                while (randPersonalCareRecipes.contains(randomlyPersonalCareRecipes.get(randNum))){
                    randNum=rand.nextInt(randomlyPersonalCareRecipes.size());
                }
                randPersonalCareRecipes.add(randomlyPersonalCareRecipes.get(randNum));
            }
            else {
                randPersonalCareRecipes.add(randomlyPersonalCareRecipes.get(randNum));
            }

        }
        return randPersonalCareRecipes;
    }

    @Override
    public List<PersonalCareRecipes> getPersonalCareByIngredients(List<String> ingredients) {
        List<PersonalCareRecipes> personalCareRecipes= personalCareRecipesRepo.findAll();
        ArrayList<PersonalCareRecipes> personalCareByIngredients = new ArrayList<>();
        for(PersonalCareRecipes personalCareRecipe : personalCareRecipes){
            int allIngredients=0;
            for(int i=0;i<ingredients.size();i++) {
                if (personalCareRecipe.getIngredients().contains(ingredients.get(i))) {
                    allIngredients++;
                }
            }
            if(allIngredients == ingredients.size())
                personalCareByIngredients.add(personalCareRecipe);

        }
        if(personalCareByIngredients.size() > 3){
            return personalCareByIngredients.subList(0,3);
        }
        else{
            return personalCareByIngredients;
        }
    }

    @Override
    public PersonalCareRecipes getPersonalCareRecipesById(long id) {
        Optional<PersonalCareRecipes> personalCareRecipes = personalCareRecipesRepo.findById(id);
        if(personalCareRecipes.isPresent()){
            return personalCareRecipes.get();
        }else{
            throw new FoodNotFoundException("FoodRecipes", "Id", id);
        }
    }
}
