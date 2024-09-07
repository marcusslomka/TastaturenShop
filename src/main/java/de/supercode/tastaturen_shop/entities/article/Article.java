package de.supercode.tastaturen_shop.entities.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.supercode.tastaturen_shop.entities.order.Cart;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(5)
    private double costs;
    @NotBlank
    private String name;
    @NotBlank
    private String discription;
    private boolean status;
    @Min(0)
    private int amountLeft;
    @ManyToMany(mappedBy = "article")
    @JsonIgnore
    private List<Cart> carts;

    public long getId() {
        return id;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
