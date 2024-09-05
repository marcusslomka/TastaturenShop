package de.supercode.tastaturen_shop.entities.order;

import de.supercode.tastaturen_shop.entities.article.Order_Article;
import de.supercode.tastaturen_shop.entities.kunde.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Order_Article> orderArticleList;

    private boolean status;
    private LocalDate orderDate;


}
