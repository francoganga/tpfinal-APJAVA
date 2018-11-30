package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{
	Materia findByTitle(String title);
}