package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/insertar")
	public ModelAndView insertar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("index");
			return mav;
		}else {
			try {
				estudianteService.insert(estudiante);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("estudiante", new Estudiante());
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	@RequestMapping(value="/borrar", method = RequestMethod.POST)
	public ModelAndView borrar(@RequestParam(value="codigo") Integer codigo) {
		ModelAndView mav = new ModelAndView();
		
		try {
			estudianteService.delete(estudianteService.findOne(codigo));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		
		mav.setViewName("listado");
		return mav;
	}

}
