package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.Problem;

import org.springframework.stereotype.Repository;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long>{
}