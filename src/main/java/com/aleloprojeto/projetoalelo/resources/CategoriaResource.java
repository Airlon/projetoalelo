package com.aleloprojeto.projetoalelo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.services.CategoriaService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController // Classe que é um Controller Rest 
@RequestMapping(value="/categorias") //Respondendo pelo Endpoint 
public class CategoriaResource {
    
	//acessando o serviço
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value="/{id}") //Requisição para obter dados
	public ResponseEntity<Object> find( @PathVariable Integer id) {
		Object obj = service.find(id);
		return ResponseEntity.ok().body(obj);
				
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
		}
	
	@ApiResponses(value = {
	@ApiResponse(code = 400, message = "Não é possível excluir uma categoria que possui produtos"),
	@ApiResponse(code = 404, message = "Código inexistente") })
	@DeleteMapping (value="/{id}") //Requisição para obter dados
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
