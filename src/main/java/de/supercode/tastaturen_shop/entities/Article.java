package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private long id;
    private double costs;
    private String name;
    private String disciption;
    private boolean status;
    private int amountLeft;
}
