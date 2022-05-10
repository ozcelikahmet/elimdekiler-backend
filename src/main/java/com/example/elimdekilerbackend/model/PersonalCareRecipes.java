package com.example.elimdekilerbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="personel_care_recipes")
public class PersonalCareRecipes {
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
