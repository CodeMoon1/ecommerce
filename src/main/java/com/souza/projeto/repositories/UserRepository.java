package com.souza.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souza.projeto.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	
}
