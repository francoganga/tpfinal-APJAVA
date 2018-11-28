package com.unaj.edu.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.unaj.edu.models.Problem;
import com.unaj.edu.repository.ProblemRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class ProblemService{
	@Autowired
    private ProblemRepository problemRepository;

    
    public void save(Problem problem) {
        problemRepository.save(problem);
    }

    public List<Problem> findAll(){
    	return problemRepository.findAll();
    }

}

