package com.unaj.edu.web;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.unaj.edu.models.*;

import com.unaj.edu.repository.*;
import com.unaj.edu.services.*;
import java.util.List;

import java.util.HashSet;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@Controller
public class Controlador {

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


	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("alumnoForm", new Alumno());

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("alumnoForm") Alumno alumnoForm, Model model) {

        System.out.println(alumnoForm.toString());
        Alumno alumno = new Alumno("usuario1","contraseña1");

        alumno.setFirstname("Carlos");
        alumno.setLastname("Sancse");

        Tutor tutor1 = new Tutor("usuario2","contraseña2");

        Tutor tutor2 = new Tutor("usuariotutor","contraseña3");

        Materia materia1 = new Materia();

        Materia materia2 = new Materia();

        Materia materia3 = new Materia();

        Materia materia4 = new Materia();

        materia1.setTitle("Matematica");

        materia2.setTitle("Lengua");

        materia3.setTitle("S. Sociales");

        materia4.setTitle("Geografia");

        HashSet alumnos = new HashSet<Alumno>();
        alumnos.add(alumno);   

        
        HashSet materias1 = new HashSet<Materia>();
        materias1.add(materia1); 
        materias1.add(materia2);

        HashSet materias2 = new HashSet<Materia>();
        materias2.add(materia3); 
        materias2.add(materia4);

        Iterator valor1 = materias1.iterator();
        Iterator valor2 = materias2.iterator();

        while (valor1.hasNext()) { 
            System.out.println(valor1.next().toString()); 
        }

        while (valor2.hasNext()) {
            System.out.println(valor2.next().toString()); 
        }


        

        tutor1.setMaterias(materias1);

        tutor2.setMaterias(materias2);

        tutor1.setAlumnos(alumnos);

        tutor2.setAlumnos(alumnos);


        materiaService.save(materia1);

        materiaService.save(materia2);

        materiaService.save(materia3);

        materiaService.save(materia4);

        alumnoService.save(alumno);

        tutorService.save(tutor1);
        
        tutorService.save(tutor2);
        
        


        return "redirect:/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String registration() {

        return "index";
    }
    
}