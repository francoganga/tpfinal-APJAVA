package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;


@Entity
@Table
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String password;

	private int puntos;

	public User(){}

	public User(String u, String p){
		this.username = u;
		this.password = p;
	}

}