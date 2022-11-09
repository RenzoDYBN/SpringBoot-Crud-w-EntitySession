package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Estudiante;


//BASICAMENTE repository tiene las acciones CRUD 
//usa la base de datos.
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{

}
