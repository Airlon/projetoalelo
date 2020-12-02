package com.aleloprojeto.projetoalelo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aleloprojeto.projetoalelo.domain.Categoria;

@RestController // Classe que é um Controller Rest
@RequestMapping(value="/categorias") //Respondendo pelo Endpoint 
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET) //Requisição para obter dados
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Minha Empresa");
		Categoria cat2 = new Categoria(2, "Meu Alelo");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
				
		return lista;
	}
}
