package de.supercode.tastaturen_shop.services;

import de.supercode.tastaturen_shop.entities.article.Article;
import de.supercode.tastaturen_shop.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public void createArticle(Article article){
        this.articleRepository.save(article);
    }
    public Article getArticle(long id){
        return articleRepository.findById(id).orElse(null);
    }
    public Article updateArticle(long id, Article article) {
        if (article == null) return null;
        Article toUpdateArticle = articleRepository.findById(id).orElse(null);
        if (toUpdateArticle == null) return null;
        toUpdateArticle.setAmountLeft(article.getAmountLeft());
        toUpdateArticle.setCosts(article.getCosts());
        toUpdateArticle.setDiscription(article.getDiscription());
        toUpdateArticle.setName(article.getName());
        toUpdateArticle.setStatus(article.isStatus());
        return articleRepository.save(toUpdateArticle);
    }
    public void deleteArticle(long id){
       articleRepository.deleteById(id);
    }
}
