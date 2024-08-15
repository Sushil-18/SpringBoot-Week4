package com.example.ProdFeatures.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;

    private String description;
}
