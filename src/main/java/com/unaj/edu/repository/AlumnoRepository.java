package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	Alumno findByUsername(String username);

	// @Query(value = "delete from alumno_tutor where alumno_id=(:alumnoId) AND tutor_id=(:tutorId)", nativeQuery=true)
	// public void deleteLink(@Param("alumnoId") Long alumnoId, @Param("tutorId") Long tutorId);

	@Query(value = "SELECT *" +
	" FROM alumno a INNER JOIN alumno_tutor atut on a.id = atut.alumno_id where tutor_id = (:tutorId) ", nativeQuery=true)
	List<Alumno> findByTutor(@Param("tutorId") Long tutorId);
}