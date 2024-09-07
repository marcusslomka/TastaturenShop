package de.supercode.tastaturen_shop.entities.order;

import de.supercode.tastaturen_shop.entities.article.Article;
import jakarta.persistence.*;

@Entity
public class Cart_Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Article
}
