package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String Street;
    private String housenumber;
    private int plz;
    private String city;
}
