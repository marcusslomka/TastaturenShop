package de.supercode.tastaturen_shop.repositories;

import de.supercode.tastaturen_shop.entities.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
