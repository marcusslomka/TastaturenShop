package de.supercode.tastaturen_shop.controllers;

import de.supercode.tastaturen_shop.entities.article.Article;
import de.supercode.tastaturen_shop.services.ArticleService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/shop/articles")
public class ArticleController {
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleValidationError(ConstraintViolationException ex){
        // wir wollen eine liste mit den validierungs fehlern bekommend
        Map<String,String> errorMap = new HashMap<>();
        ex.getConstraintViolations()
                .forEach(violation-> {
                    String fieldName = violation.getPropertyPath().toString();
                    String errorMessage = violation.getMessage();
                    errorMap.put(fieldName,errorMessage);
                });
        return errorMap;
    }
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles(){
        return ResponseEntity.status(HttpStatus.FOUND).body(articleService.getAllArticles());
    }
    @PostMapping
   public ResponseEntity<Article> createNewArticle (@RequestBody Article article){
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.createArticle(article));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id){
        Article toGetArticle = articleService.getArticle(id);
        if (toGetArticle == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(toGetArticle,HttpStatus.FOUND);
   }
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody Article article){
        Article toUpdateArticle = articleService.updateArticle(id,article);
        if (toUpdateArticle==null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(toUpdateArticle,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle (@PathVariable long id){
        if (articleService.deleteArticle(id)) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
   }
}
