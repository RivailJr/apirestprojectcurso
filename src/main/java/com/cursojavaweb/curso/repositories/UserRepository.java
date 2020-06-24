package com.cursojavaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojavaweb.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
