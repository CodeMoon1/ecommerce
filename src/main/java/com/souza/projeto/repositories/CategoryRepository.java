package com.souza.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souza.projeto.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
