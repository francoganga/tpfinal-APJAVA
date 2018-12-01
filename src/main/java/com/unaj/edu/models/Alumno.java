package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private String password;

	private String salt;

	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.LAZY)
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
	// @Override
 //    public boolean equals(Object o) {
 //        if (this == o) return true;
 
 //        if (o == null || getClass() != o.getClass()) 
 //            return false;
 
 //        PostTagId that = (PostTagId) o;
 //        return Objects.equals(postId, that.postId) && 
 //               Objects.equals(tagId, that.tagId);
 //    }
 
 //    @Override
 //    public int hashCode() {
 //        return Objects.hash(postId, tagId);
 //    }

}