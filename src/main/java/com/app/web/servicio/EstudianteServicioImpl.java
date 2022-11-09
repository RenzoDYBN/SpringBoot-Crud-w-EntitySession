package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repository;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		return repository.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repository.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudianteporId(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repository.save(estudiante);
		
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repository.deleteById(id);
		
	}

}
