package de.supercode.tastaturen_shop.entities.order;

import de.supercode.tastaturen_shop.entities.article.Article;
import de.supercode.tastaturen_shop.entities.kunde.Customer;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Customer customer;
    @ManyToMany()
    private List<Cart_Article> cartArticleList;

}
