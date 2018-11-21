package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.User;



public interface UserRepository extends JpaRepository<User, Long>{
	
}