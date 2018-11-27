package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.*;

import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{
	Tutor findByUsername(String username);
}