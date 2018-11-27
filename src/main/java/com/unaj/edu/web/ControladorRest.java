package com.unaj.edu.web;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.unaj.edu.models.Alumno;
import com.unaj.edu.models.Response;

import com.unaj.edu.services.AlumnoService;

@RestController
public class ControladorRest {

	@Autowired
    AlumnoService alumnoService;
 
	
 
	@GetMapping(value = "/alumno")
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
 
}