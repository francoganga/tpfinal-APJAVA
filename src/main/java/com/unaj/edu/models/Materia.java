package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;



@Entity
@Table
@Data
public class Materia implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String description;

	@ManyToMany(mappedBy = "materias")
	private Set<Tutor> tutores;

	//Buscar mas atributos de materia

	public Materia(){}

	public Materia(String title, String description, Set<Tutor> tutores){
		this.title = title;
		this.description = description;
		this.tutores = tutores;
	}


    public Set<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(Set<Tutor> tutores) {
        this.tutores = tutores;
    }

    @Override
    public String toString() {
        String result = String.format(
                "materia [id=%d, titulo='%s']%n",
                id, title);
        if (tutores != null) {
            for(Tutor tutor : tutores) {
                result += String.format(
                        "Tutor[id=%d, username='%s']%n",
                        tutor.getId(), tutor.getUsername());
            }
        }

        return result;
    }




}