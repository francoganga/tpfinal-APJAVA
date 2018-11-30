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
public class TutorService{
	@Autowired
    private TutorRepository tutorRepository;

    
    public void save(Tutor tutor) {
        String salt = PasswordEncoder.getSalt(30);

    	String securePassword = PasswordEncoder.generateSecurePassword(tutor.getPassword(), salt);

    	tutor.setPassword(securePassword);
    	tutor.setSalt(salt);
        tutorRepository.save(tutor);
    }

    public Tutor findByUsername(String username) {
        return tutorRepository.findByUsername(username);
    }
    public List<Tutor> findByMateria(Long materiaId){
        return tutorRepository.findByMateria(materiaId);
    }

}

