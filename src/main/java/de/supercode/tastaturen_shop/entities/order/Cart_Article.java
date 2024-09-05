package de.supercode.tastaturen_shop.entities.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart_Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
