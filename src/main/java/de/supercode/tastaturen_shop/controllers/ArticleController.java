package de.supercode.tastaturen_shop.controllers;

import de.supercode.tastaturen_shop.services.ArticleService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
}
