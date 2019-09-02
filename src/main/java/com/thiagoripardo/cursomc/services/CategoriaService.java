package com.thiagoripardo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagoripardo.cursomc.domain.Categoria;
import com.thiagoripardo.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> Obj = repo.findById(id);
		return Obj.orElse(null);
	}
	
}
