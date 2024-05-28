package com.souza.projeto.services;

import java.util.List;
import java.util.Optional;

import com.souza.projeto.services.exceptions.DatabaseException;
import com.souza.projeto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.souza.projeto.entities.Product;
import com.souza.projeto.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository ProductRepository;

	public List<Product> findAll() {
		return ProductRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = ProductRepository.findById(id);
		return obj.get();
	}

	public Product insert (Product product){
		return ProductRepository.save(product);
	}


}
