package com.cursojavaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavaweb.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
