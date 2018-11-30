package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{
	Tutor findByUsername(String username);
	@Query(value = "SELECT *" +
	" FROM tutor t INNER JOIN tutor_materia tm on t.id = tm.tutor_id WHERE materia_id = (:materiaId) ", nativeQuery=true)
	List<Tutor> findByMateria(@Param("materiaId") Long materiaId);
}