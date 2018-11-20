package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;


@Entity
@Table
@Getter @Setter
public class User {
	@Id
	private String username;

	private String password;

	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private int phone;

	public User(){}

}