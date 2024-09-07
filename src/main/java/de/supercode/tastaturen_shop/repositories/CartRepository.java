package de.supercode.tastaturen_shop.repositories;

import de.supercode.tastaturen_shop.entities.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
