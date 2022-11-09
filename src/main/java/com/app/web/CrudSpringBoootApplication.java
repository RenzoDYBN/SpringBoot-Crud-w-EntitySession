package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@SpringBootApplication 
public class CrudSpringBoootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBoootApplication.class, args);
	}

	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
	
		/*
		Estudiante es1 = new Estudiante("renzo","bustamante","renzodylan@hotmail.com");
		repositorio.save(es1);

		Estudiante es2 = new Estudiante("fabrimi612","cholito","pegaso@hotmail.com");
		repositorio.save(es2);
		*/
	}

}
