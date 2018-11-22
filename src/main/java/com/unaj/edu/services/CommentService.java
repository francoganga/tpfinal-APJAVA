package com.unaj.edu.services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.unaj.edu.models.Comment;
import com.unaj.edu.repository.CommentRepository;

import java.util.HashSet;

@Service
public class CommentService{
	@Autowired
    private CommentRepository commentRepository;

    
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}

