package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kunde {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private Address Address;

    private String firstName;
    private String lastName;
    private String email;


}
