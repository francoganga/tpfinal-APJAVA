package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;


@Entity
@Table
@Getter @Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String password;

	public User(){}

}