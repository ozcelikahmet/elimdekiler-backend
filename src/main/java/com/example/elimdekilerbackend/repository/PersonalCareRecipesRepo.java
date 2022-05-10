package com.example.elimdekilerbackend.repository;

import com.example.elimdekilerbackend.model.PersonalCareRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalCareRecipesRepo extends JpaRepository<PersonalCareRecipes, Long> {
}
