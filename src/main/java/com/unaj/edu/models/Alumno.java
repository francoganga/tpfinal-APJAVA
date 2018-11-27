package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Table
@Data
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private String password;

	private String salt;

	@ManyToMany(mappedBy = "alumnos")
	private Set<Tutor> tutores;

	//private int type;

	private String email;

	private int points;


	public Alumno(){}

	public Alumno(String u, String p){
		this.username = u;
		this.password = p;
		this.points = 0;
	}

}