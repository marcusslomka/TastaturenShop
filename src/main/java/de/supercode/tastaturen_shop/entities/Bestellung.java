package de.supercode.tastaturen_shop.entities;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;
import org.hibernate.mapping.List;

import java.time.LocalDate;

@Entity
public class Bestellung {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Kunde kunde;

    private boolean status;
    private LocalDate orderDate;

    @JoinTable
    @OneToMany
    private List<Bestellung_Artikel> bestellung_artikelList;


}
