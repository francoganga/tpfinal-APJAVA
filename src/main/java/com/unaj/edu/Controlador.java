package com.unaj.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.*;

public class Controlador extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(Controlador.class);

	public Controlador(){
		super();
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response )
	throws ServletException, IOException {
	
	logger.debug("asasdasd debug");

	String text = request.getParameter("text");

	logger.info(text);



	}

}