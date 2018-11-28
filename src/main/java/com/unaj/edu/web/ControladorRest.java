package com.unaj.edu.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.unaj.edu.models.*;

import com.unaj.edu.services.*;

@RestController
public class ControladorRest {

	@Autowired
    AlumnoService alumnoService;

    @Autowired
    ProblemService problemService;
 
	
 
	@GetMapping(value = "/alumnoRest")
	public Response getResource() {
		
		Alumno alumno = alumnoService.findByUsername("usuario1");

		//System.out.println(alumno.toString());

		ArrayList<String> data = new ArrayList<String>();

		data.add(alumno.getUsername());
		data.add(alumno.getFirstname());
		data.add(alumno.getLastname());

		Response response = new Response("Done", data);
		return response;
	}
	@GetMapping(value = "/cargarProblemas")
	public Response cargarProblemas() {

		List<Problem> problemas = problemService.findAll();

		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(); 
		

		Iterator valor = problemas.iterator();

		Problem problema;

		while (valor.hasNext()) {

			problema = (Problem)valor.next();

			ArrayList<String> datachico = new ArrayList<String>();
			
			datachico.add(problema.getTitle());

			datachico.add(problema.getText());

			datachico.add(problema.getAlumno().getUsername());

			data.add(datachico);
		}

		
			
		

		Response response = new Response("Done", data);
		return response;
	}
 
}