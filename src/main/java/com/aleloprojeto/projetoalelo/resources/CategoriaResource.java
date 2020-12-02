package com.aleloprojeto.projetoalelo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // Classe que é um Controller Rest
@RequestMapping(value="/categorias") //Respondendo pelo Endpoint 
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET) //Requisição para obter dados
	public String listar() {
		return "Rest está funcionando!";
	}
}
