package com.unaj.edu.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.unaj.edu.models.*;

import com.unaj.edu.services.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@RestController
public class ControladorRest {

	@Autowired
    AlumnoService alumnoService;

    @Autowired
    TutorService tutorService;

    @Autowired
    CommentService commentService;

    @Autowired
    ProblemService problemService;

    @Autowired
    MateriaService materiaService;
 
	
 
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

			datachico.add(Long.toString(problema.getId()));

			data.add(datachico);
		}

		
			
		

		Response response = new Response("Done", data);
		return response;
	}
	@GetMapping(value = "/getComments")
	public Response getComments(@RequestParam("problemId") String problem_id ) {
		//ESTO ESTA MAL PORQUE ME TRAIGO TODOS LOS COMENTARIOS EN VES DE
		//LOS COMENTARIOS DEL PROBLEMA ARREGALR PLS THANKS
		// Problem problem = problemService.findById(Long.parseLong(problem_id,10));

		Long problemID = Long.parseLong(problem_id,10);

		 List<Comment> comments = commentService.findAll();



		 ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

		 Iterator valor = comments.iterator();

		 Comment comment;


		while (valor.hasNext()) {

			comment =(Comment) valor.next();
			if(comment.getProblem().getId() == problemID ){
				ArrayList<String> datachico = new ArrayList<String>();
			
				datachico.add(Long.toString(comment.getId()));

				if(comment.getAlumno() == null){
					datachico.add(comment.getTutor().getUsername());
				}else if( comment.getTutor() == null){
					datachico.add(comment.getAlumno().getUsername());
				}
				



				datachico.add(comment.getContent());
				datachico.add(Integer.toString(comment.getPoints()));

				
				data.add(datachico);
			}

			
		}

		

		

		Response response = new Response("Done", data);
		return response;
	}
	@GetMapping(value= "/filtrarProblemaResults")
	public Response filtrarMateria(@RequestParam("materiaId") String materiaId){

		

		List<Problem> problems = problemService.findByMateria(Long.parseLong(materiaId,10));

		
		JSONArray array = new JSONArray();

		Iterator value = problems.iterator();

		Problem problem;

		while(value.hasNext()){
			problem = (Problem) value.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", problem.getId());
			jsonObj.put("user", problem.getAlumno().getUsername());
			jsonObj.put("title", problem.getTitle());
			jsonObj.put("text", problem.getText());

			array.add(jsonObj);

		}

		Response response = new Response("Done", array);

		return response;
	}
	@GetMapping(value= "/filtrarTutorResults")
	public Response filtrarTutorResults(@RequestParam("materiaId") String materiaId){

		

		List<Tutor> tutores = tutorService.findByMateria(Long.parseLong(materiaId,10));

		
		JSONArray array = new JSONArray();

		Iterator value = tutores.iterator();

		Tutor tutor;

		while(value.hasNext()){
			tutor = (Tutor) value.next();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", tutor.getId());
			jsonObj.put("user", tutor.getUsername());
			jsonObj.put("firstname", tutor.getFirstname());
			jsonObj.put("lastname", tutor.getLastname());
			jsonObj.put("email", tutor.getEmail());
			jsonObj.put("rankPoints", tutor.getRankPoints());
			jsonObj.put("commentPoints", tutor.getCommentPoints());

			array.add(jsonObj);

		}

		Response response = new Response("Done", array);

		return response;
	}
 
}