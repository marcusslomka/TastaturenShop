package de.supercode.tastaturen_shop.services;

import de.supercode.tastaturen_shop.dtos.AddArticleToCartDto;
import de.supercode.tastaturen_shop.entities.article.Article;
import de.supercode.tastaturen_shop.entities.kunde.Customer;
import de.supercode.tastaturen_shop.entities.order.Cart;
import de.supercode.tastaturen_shop.repositories.ArticleRepository;
import de.supercode.tastaturen_shop.repositories.CartRepository;
import de.supercode.tastaturen_shop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    CartRepository cartRepository;
    ArticleRepository articleRepository;
    CustomerRepository customerRepository;

    public CartService(CartRepository cartRepository, ArticleRepository articleRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.articleRepository = articleRepository;
        this.customerRepository = customerRepository;
    }
    public void addArticleToCart(AddArticleToCartDto dto){
        Customer customer = customerRepository.findById(dto.getCustomerID()).orElseThrow();
        Article article = articleRepository.findById(dto.getArticleID()).orElseThrow();

        Cart customerCart = customer.getCart();
        if (customerCart == null){
            customerCart = new Cart();
            customerCart.setCustomer(customer);
            customer.setCart(customerCart);
        }
        customerCart.getArticleList().add(article);
    }
}
