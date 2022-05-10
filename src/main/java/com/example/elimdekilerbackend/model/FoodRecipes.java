package com.example.elimdekilerbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name="food_recipes")
public class FoodRecipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "ingredients", nullable = false)
    private String ingredients;

    @Column(name= "description", nullable = false)
    private String description;

    @Column(name= "image", nullable = false)
    private String image;

}
