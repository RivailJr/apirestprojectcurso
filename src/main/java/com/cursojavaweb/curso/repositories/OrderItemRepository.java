package com.cursojavaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavaweb.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
