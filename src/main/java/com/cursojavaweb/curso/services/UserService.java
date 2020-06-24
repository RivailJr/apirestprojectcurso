package com.cursojavaweb.curso.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cursojavaweb.curso.entities.User;
import com.cursojavaweb.curso.repositories.UserRepository;
import com.cursojavaweb.curso.services.exceptions.DataBaseException;
import com.cursojavaweb.curso.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
	}
	
	public User insert(User ob) {
		return repository.save(ob);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage()); 
		}
	}
	
	public User update(Long id, User ob) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, ob);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User ob) {
		entity.setName(ob.getName());
		entity.setEmail(ob.getEmail());
		entity.setPhone(ob.getPhone());
	}
}
