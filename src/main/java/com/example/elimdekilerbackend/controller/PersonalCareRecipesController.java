package com.example.elimdekilerbackend.controller;

import com.example.elimdekilerbackend.model.PersonalCareRecipes;
import com.example.elimdekilerbackend.service.PersonalCareRecipesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/personal-care-recipes")
public class PersonalCareRecipesController {

    private PersonalCareRecipesService personalCareRecipesService;

    public PersonalCareRecipesController(PersonalCareRecipesService personalCareRecipesService) {
        this.personalCareRecipesService = personalCareRecipesService;
    }

    @PostMapping()
    public ResponseEntity<PersonalCareRecipes> savePersonalCareRecipes(@RequestBody PersonalCareRecipes personalCareRecipes){
        return new ResponseEntity<PersonalCareRecipes>(personalCareRecipesService.savePersonalCare(personalCareRecipes), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<PersonalCareRecipes> getAllFoodRecipes(){
        return personalCareRecipesService.getAllPersonalCareRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalCareRecipes> getFoodRecipesById(@PathVariable("id") long id){
        return new ResponseEntity<>(personalCareRecipesService.getPersonalCareRecipesById(id), HttpStatus.OK);
    }

    @GetMapping("/rand")
    public List<PersonalCareRecipes> getRandomlyRecipes() {
        return personalCareRecipesService.getRandomlyRecipes();
    }

    @GetMapping("/ingredients/{ingredients}")
    public List<PersonalCareRecipes> getPersonalCareByIngredients(@PathVariable("ingredients") List<String> ingredients) {
        return personalCareRecipesService.getPersonalCareByIngredients(ingredients);
    }
}
