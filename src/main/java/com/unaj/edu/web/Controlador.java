package com.unaj.edu;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.unaj.edu.models.User;

import com.unaj.edu.repository.UserRepository;
import com.unaj.edu.services.UserService;
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("userForm") User userForm, Model model) {
        
        User user = new User("usuario1","contraseña1");


        userService.save(user);
        


        return "redirect:/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String registration() {

        return "index";
    }
    
}