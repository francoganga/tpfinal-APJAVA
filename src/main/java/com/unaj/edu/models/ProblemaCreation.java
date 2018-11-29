package com.unaj.edu.models;

import javax.persistence.*;
import lombok.*;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
public class ProblemaCreation {
	private Long id;

	private boolean resolved;

	private String title;

	private String text;

    private String materiaTitle;


	

}