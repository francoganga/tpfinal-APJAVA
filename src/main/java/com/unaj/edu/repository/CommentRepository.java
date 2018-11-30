package com.unaj.edu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.unaj.edu.models.Comment;
import com.unaj.edu.models.Problem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value = "SELECT *  from Comment where problem_comment_id=(:problemId)", nativeQuery=true)
	public List<Comment> findByProblem(@Param("problemId") Long problemId);
}