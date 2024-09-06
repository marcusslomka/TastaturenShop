package de.supercode.tastaturen_shop.services;

import de.supercode.tastaturen_shop.entities.article.Article;
import de.supercode.tastaturen_shop.repositories.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    public Article createArticle(Article article){
        return this.articleRepository.save(article);
    }
    public Article getArticle(long id){
        return articleRepository.findById(id).orElse(null);
    }
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
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
    public Boolean deleteArticle(long id){
        Optional<Article> toDeleteArticle = articleRepository.findById(id);
        if (toDeleteArticle.isEmpty()) return false;
        else {
            articleRepository.deleteById(id);
            return true;
        }
    }
}
