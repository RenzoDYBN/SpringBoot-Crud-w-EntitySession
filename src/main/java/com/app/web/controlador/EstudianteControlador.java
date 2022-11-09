package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

@Controller
@RequestMapping("/estudiante")
public class EstudianteControlador {
	
	@Autowired
	private EstudianteServicio serviceEstudiante;
	
	@GetMapping({"/listar","/"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", serviceEstudiante.listarEstudiantes());
		return "estudiantes"; // nos retorna al archivo estudiantes
	}
	
	@GetMapping("/agregar")
	public String crearEstudianteFormulario(Model modelo) {
		Estudiante estuNue = new Estudiante();
		modelo.addAttribute("estudiante",estuNue);
		return "estudiantesFormulario"; // nos retorna al archivo estudiantes
	}
	
	@PostMapping("/procesarInfo")
	public String procesarEstudiante(@ModelAttribute(name="estudiante") Estudiante estudiante) {
		serviceEstudiante.guardarEstudiante(estudiante);
		return "redirect:/estudiante/listar";
	}
	
	@GetMapping("/editarEstudiante")
	public String mostrarFormularioEditar(@RequestParam(name="id") Long id,Model model) {
		System.out.println(id);
		model.addAttribute("estudiante",serviceEstudiante.obtenerEstudianteporId(id));
		return "editarEstudiante";
	}
	
	@PostMapping("/procesarEditar")
	public String actualizarEstudiante(@RequestParam(name="id") Long id, @ModelAttribute(name="estudiante") Estudiante estudiante
			, Model modelo) {
		Estudiante estudiantExistente = serviceEstudiante.obtenerEstudianteporId(id);
		estudiantExistente.setId(id);
		estudiantExistente.setNombre(estudiante.getNombre());
		estudiantExistente.setApellido(estudiante.getApellido());
		estudiantExistente.setEmail(estudiante.getEmail());
		serviceEstudiante.actualizarEstudiante(estudiantExistente);
		return "redirect:/estudiante/listar";
	}
	
	@GetMapping("/eliminar")
	public String eliminarRegistro(@RequestParam(name="id") Long id, @ModelAttribute(name="estudiante") Estudiante estudiante
			, Model modelo) {
		
		serviceEstudiante.eliminarEstudiante(id);
		
		return "redirect:/estudiante/listar";
	}
}	
