package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.Problem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long>{

	@Query(value = "SELECT *  from Problem where materia_problem_id=(:materiaId)", nativeQuery=true)
	public List<Problem> findByMateria(@Param("materiaId") Long materiaId);
}