package com.cursojavaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavaweb.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
