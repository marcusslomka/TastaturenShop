package de.supercode.tastaturen_shop.entities.article;

import de.supercode.tastaturen_shop.entities.order.Order;
import jakarta.persistence.*;

@Entity
public class Order_Article {

    @JoinColumn(name = "bestellung_id")
    private Order order;

    @ManyToMany
    private Article article;

    private int anzahl;



}
