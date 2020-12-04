package com.aleloprojeto.projetoalelo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.services.CategoriaService;

@RestController // Classe que é um Controller Rest
@RequestMapping(value="/categorias") //Respondendo pelo Endpoint 
public class CategoriaResource {
    
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //Requisição para obter dados
	public ResponseEntity<?> find( @PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
				
	}
}
