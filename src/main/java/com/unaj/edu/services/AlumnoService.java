package com.unaj.edu.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.unaj.edu.models.*;
import com.unaj.edu.repository.*;

import com.unaj.edu.web.PasswordEncoder;

import java.util.Set;
import java.util.List;

@Service
public class AlumnoService{
	@Autowired
    private AlumnoRepository alumnoRepository;

    
    public void save(Alumno alumno) {
        String salt = PasswordEncoder.getSalt(30);

    	String securePassword = PasswordEncoder.generateSecurePassword(alumno.getPassword(), salt);

    	alumno.setPassword(securePassword);
    	alumno.setSalt(salt);
        alumnoRepository.save(alumno);
    }

    public Alumno findByUsername(String username) {
        return alumnoRepository.findByUsername(username);
    }
}

