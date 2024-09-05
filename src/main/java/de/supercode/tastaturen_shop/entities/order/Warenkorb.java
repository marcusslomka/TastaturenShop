package de.supercode.tastaturen_shop.entities.order;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import jakarta.persistence.*;

@Entity
public class Warenkorb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Customer customer;

}
