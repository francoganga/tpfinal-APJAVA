package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Set;



@Entity
@Table
@Data
public class Tutor implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private String password;

	private String salt;

	//private int type;

	private String email;

	private int rankPoints;

	private int commentPoints;



	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tutor_materia", joinColumns = @JoinColumn(name = "tutor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"))
    private Set<Materia> materias;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "alumno_tutor", joinColumns = @JoinColumn(name = "tutor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id"))
    private Set<Alumno> alumnos;


	public Tutor(String u, String p){
		this.username = u;
		this.password = p;
		this.rankPoints = 0;
		this.commentPoints = 0;
	}

	public Tutor(String u, String p, Set<Materia> materias){
		this.username = u;
		this.password = p;
		this.materias = materias;
		this.rankPoints = 0;
		this.commentPoints = 0;
	}


	
    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }



    @Override
    public String toString() {
        String result = String.format(
                "Tutores [id=%d, username='%s']%n",
                id, username);
        if (materias != null) {
            for(Materia materia : materias) {
                result += String.format(
                        "Materia[id=%d, title='%s']%n",
                        materia.getId(), materia.getTitle());
            }
        }

        return result;
    }
}