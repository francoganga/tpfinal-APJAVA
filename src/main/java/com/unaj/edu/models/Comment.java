package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "problem_comment_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Problem problem;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "alumno_comment_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tutor_comment_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Tutor tutor;

	private int points;

	public Comment(){}

	public Comment(Problem problem, String cont){
		this.problem = problem;
		this.content = cont;
	}

}