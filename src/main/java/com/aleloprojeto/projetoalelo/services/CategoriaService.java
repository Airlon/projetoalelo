package com.aleloprojeto.projetoalelo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
	@Autowired //instanciando o repositório, acessar obj de acesso a dados 
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null); 
		
		
	}
}
