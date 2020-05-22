package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDao.findAll();
	}

	
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		estudianteDao.insert(estudiante);
		
	}

	@Transactional
	public void delete(Estudiante estudiante) throws DataAccessException {
		estudianteDao.delete(estudiante);
		
	}


	
	public Estudiante findOne(Integer codigo) throws DataAccessException {
		return estudianteDao.findOne(codigo);
	}


}
