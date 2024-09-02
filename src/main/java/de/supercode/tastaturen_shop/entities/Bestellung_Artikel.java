package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Bestellung_Artikel {

    @Id
    private long bestellung_ID;

}
