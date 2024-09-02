package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Warenkorb {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Kunde kunde;

}
