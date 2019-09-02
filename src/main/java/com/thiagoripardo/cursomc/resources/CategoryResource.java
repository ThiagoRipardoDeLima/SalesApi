package com.thiagoripardo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagoripardo.cursomc.domain.Categoria;
import com.thiagoripardo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoryResource {
	
	@Autowired
	private CategoriaService categoriaServico;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria categoria = categoriaServico.find(id);
		return ResponseEntity.ok().body(categoria);
	}
}
