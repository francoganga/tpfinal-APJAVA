package com.unaj.edu;



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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@Controller
public class Controlador {

	@Autowired
	UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    ProblemService problemService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User userForm, Model model) {


        System.out.println(userForm.toString());
        
        // User user1 = new User("usuario1","contraseña1");

        // User user2 = new User("usuario2","contraseña2");

        // Problem problema = new Problem(user1,"Tengo un problema con spring MVC","No puedo hacer que ande, que hago?");

        // Comment comentario1 = new Comment(user1,problema,"no importa ya lo solucione");

        // Comment comentario2 = new Comment(user2,problema,"HIJO DE P*TA COMO HICISTE");


        // userService.save(user1);
        // userService.save(user2);

        // problemService.save(problema);

        // commentService.save(comentario1);
        // commentService.save(comentario2);

        //User testuser = userService.findByUsername("usuario1");

        //System.out.println(testuser.getUsername());
        


        return "redirect:/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String registration() {

        return "index";
    }
    
}