package com.example.elimdekilerbackend.repository;

import com.example.elimdekilerbackend.model.FoodRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRecipesRepository extends JpaRepository<FoodRecipes, Long> {

}
