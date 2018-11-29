package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table
@Data
public class Problem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private boolean resolved;

	private String title;

	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno_problem_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "materia_problem_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Materia materia;


	public Problem(){}

	public Problem(String title, String text){
		this.title = title;
		this.text = text;
		this.resolved = false;
	}

}