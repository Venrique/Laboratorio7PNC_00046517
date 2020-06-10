package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDao;
	
	
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.findAll();
	}

	
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.save(estudiante);
		
	}

	@Transactional
	public void delete(Estudiante estudiante) throws DataAccessException {
		estudianteRepo.delete(estudiante);
		
	}


	
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteRepo.getOne(codigo);
	}


}
