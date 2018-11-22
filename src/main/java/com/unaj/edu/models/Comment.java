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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_comment_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	private int points;

	public Comment(){}

	public Comment(User user, Problem problem, String cont){
		this.problem = problem;
		this.user = user;
		this.content = cont;
	}

}