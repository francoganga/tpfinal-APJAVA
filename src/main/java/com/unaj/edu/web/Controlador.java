package com.unaj.edu.web;


import java.util.ArrayList;
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
import com.unaj.edu.web.PasswordEncoder;
import java.util.List;

import java.util.HashSet;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;

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

    final static Logger logger = Logger.getLogger(Controlador.class); 


	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String registration(Model model, HttpSession session) {
        System.out.println(session.getAttribute("userLogged"));
        model.addAttribute("userForm", new UserLogin());

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") UserLogin userLogin, Model model, HttpSession session) {

                 
        System.out.println("\n username desde form: " + userLogin.getUsername());
        System.out.println("\n password desde form: " + userLogin.getPassword());
        System.out.println("\n type desde form: " + userLogin.getType());

        if (userLogin.getType().equals("tutor")) {
            Tutor tutor = tutorService.findByUsername(userLogin.getUsername());
            if (tutor != null) {                
                if(PasswordEncoder.verifyUserPassword(userLogin.getPassword(),tutor.getPassword(),tutor.getSalt()) == true){
                    session.setAttribute("userLogged",userLogin.getUsername());
                    session.setAttribute("userType",userLogin.getType());
                    System.out.println("Bienvenido "+userLogin.getUsername()+"!!");
                    return "redirect:/" + userLogin.getType();
                }else{
                    System.out.println("Usuario o contraseña incorrectas");
                    model.addAttribute("error","Usuario o contraseña incorrectas");
                    return "login";
                }            
            }else{
                System.out.println("Usuario o contraseña incorrectas");
                model.addAttribute("error","Usuario o contraseña incorrectas");
                return "login";
            }
            

        }else if (userLogin.getType().equals("alumno")) {
            Alumno alumno = alumnoService.findByUsername(userLogin.getUsername());
            if (alumno != null) {
                if(PasswordEncoder.verifyUserPassword(userLogin.getPassword(),alumno.getPassword(),alumno.getSalt()) == true){
                    session.setAttribute("userLogged",userLogin.getUsername());                    
                    session.setAttribute("userType",userLogin.getType());
                    System.out.println("Bienvenido "+userLogin.getUsername()+"!!");
                    return "redirect:/" + userLogin.getType();
                }else{
                    System.out.println("Usuario o contraseña incorrectas");
                    model.addAttribute("error","Usuario o contraseña incorrectas");
                    return "login";
                }
            }else {
                System.out.println("Usuario o contraseña incorrectas");
                model.addAttribute("error","Usuario o contraseña incorrectas");
                return "login";
            }
        }

        // System.out.println(alumnoForm.toString());
        // Alumno alumno = new Alumno("usuario1","contraseña1");

        // alumno.setFirstname("Carlos");
        // alumno.setLastname("Sans");



        // Tutor tutor2 = new Tutor("usuariotutor","contraseña3");

        // Materia materia1 = new Materia();

        // Materia materia2 = new Materia();

        // Materia materia3 = new Materia();

        // Materia materia4 = new Materia();

        // materia1.setTitle("Matematica");

        // materia2.setTitle("Lengua");

        // materia3.setTitle("S. Sociales");

        // materia4.setTitle("Geografia");

        // HashSet alumnos = new HashSet<Alumno>();
        // alumnos.add(alumno);   

        
        // HashSet materias1 = new HashSet<Materia>();
        // materias1.add(materia1); 
        // materias1.add(materia2);

        // HashSet materias2 = new HashSet<Materia>();
        // materias2.add(materia3); 
        // materias2.add(materia4);

        // Iterator valor1 = materias1.iterator();
        // Iterator valor2 = materias2.iterator();

        // while (valor1.hasNext()) { 
        //     System.out.println(valor1.next().toString()); 
        // }

        // while (valor2.hasNext()) {
        //     System.out.println(valor2.next().toString()); 
        // }


        

        // tutor1.setMaterias(materias1);

        // tutor2.setMaterias(materias2);

        // tutor1.setAlumnos(alumnos);

        // tutor2.setAlumnos(alumnos);


        // materiaService.save(materia1);

        // materiaService.save(materia2);

        // materiaService.save(materia3);

        // materiaService.save(materia4);

        // alumnoService.save(alumno);

        // tutorService.save(tutor1);
        
        // tutorService.save(tutor2);
        
        


        return "redirect:/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String registration() {

        return "index";
    }

    @GetMapping(value = "/register")
    public String registerView(Model model){
        model.addAttribute("alumnoForm", new UserRegistration());
        return "register";
    }
    @PostMapping(value = "/register")
    public String register(@ModelAttribute("alumnoForm") UserRegistration alumnoForm, Model model){
        System.out.println(alumnoForm.toString());
        if( alumnoForm.getType().equals("tutor") ){

            //Tutor tutor = new Tutor();
            Tutor tutor = tutorService.findByUsername(alumnoForm.getUsername());
            if ( tutor == null){

                tutor = new Tutor();

                tutor.setUsername(alumnoForm.getUsername());
                tutor.setPassword(alumnoForm.getPassword());
                tutor.setFirstname(alumnoForm.getFirstname());
                tutor.setLastname(alumnoForm.getLastname());
                tutor.setEmail(alumnoForm.getEmail());
                tutorService.save(tutor);
                return "redirect:/login";
            }else{
                model.addAttribute("error","Usuario ya existe");
                return "register";
            }
            
        }
        else if( alumnoForm.getType().equals("alumno")){

            //Alumno alumno = new Alumno();

            Alumno alumno = alumnoService.findByUsername(alumnoForm.getUsername());

            if(alumno == null){
                alumno = new Alumno();
                alumno.setUsername(alumnoForm.getUsername());
                alumno.setPassword(alumnoForm.getPassword());
                alumno.setFirstname(alumnoForm.getFirstname());
                alumno.setLastname(alumnoForm.getLastname());
                alumno.setEmail(alumnoForm.getEmail());
                alumnoService.save(alumno);
                return "redirect:/login";
            }else{
                model.addAttribute("error", "Usuario ya existe");
                return "register";
            }
            
        }
        return "redirect:/index";
    }

    @GetMapping(value = "/logout")
    public String logout(Model model, HttpSession session){
        session.setAttribute("userLogged","");
        session.setAttribute("userType","");
        session.setAttribute("error","Ha cerrado sesion exitosamente");


        System.out.println("PASA");
        model.addAttribute("userForm", new UserLogin());
        return "redirect:/login";
    }

    @GetMapping(value = "/alumno")
    public String alumno(Model model, HttpSession session){


        return "alumno";
    }

    @GetMapping(value = "/crearProblema")
    public String problemaView(Model model){
        model.addAttribute("problemaForm", new ProblemaCreation());
        return "crearProblema";
    }

    @PostMapping(value = "/crearProblema")
    public String crearProblema(@ModelAttribute("problemaForm") ProblemaCreation problemaForm, Model model, HttpSession session){
        Problem problema = new Problem();

        problema.setTitle(problemaForm.getTitle());
        problema.setText(problemaForm.getText());
        Alumno alumno = alumnoService.findByUsername((String)session.getAttribute("userLogged"));
        problema.setAlumno(alumno);
        Materia materia = materiaService.findByTitle(problemaForm.getMateriaTitle());
        problema.setMateria(materia);
        problemService.save(problema);

        return "alumno";
    }
    

    @GetMapping(value = "/tutor")
    public String tutor(){


        return "tutor";
    }

    @GetMapping(value = "/problema")
    public String mostrarProblem(@RequestParam("problemId") String problemId, Model model){

        Long problemId_long = Long.parseLong(problemId,10);

        Problem problem = problemService.findById(problemId_long);
        model.addAttribute("text", problem.getText());
        model.addAttribute("title",problem.getTitle());
        model.addAttribute("problem_id",problem.getId());
  
        return "problem";
    }
    
}