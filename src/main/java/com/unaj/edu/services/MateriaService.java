package com.unaj.edu.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.unaj.edu.models.*;
import com.unaj.edu.repository.*;

import java.util.Set;
import java.util.List;

@Service
public class MateriaService{
	@Autowired
    private MateriaRepository materiaRepository;

    
    public void save(Materia materia) {
        materiaRepository.save(materia);
    }
    public Materia findByTitle(String title) {
        return materiaRepository.findByTitle(title);
    }



}

