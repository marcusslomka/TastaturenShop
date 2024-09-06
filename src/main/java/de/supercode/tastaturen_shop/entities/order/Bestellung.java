package de.supercode.tastaturen_shop.entities.order;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Bestellung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToMany
//    private Customer customer;

//    @OneToMany
    //private List<Order_Article> orderArticleList;

    private boolean status;
    private LocalDate orderDate;


}
