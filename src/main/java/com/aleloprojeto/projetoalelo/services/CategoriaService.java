package com.aleloprojeto.projetoalelo.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.repositories.CategoriaRepository;
import com.aleloprojeto.projetoalelo.resources.exception.StandardError;
import com.aleloprojeto.projetoalelo.services.exceptions.DataIntegrityException;


@Service
public class CategoriaService {
    
	@Autowired //instanciando o repositório, acessar obj de acesso a dados 
	private CategoriaRepository repo;
	
	public Object find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}else {return new StandardError(1, "Objeto não encontrado! Id:" +id +"", + new Date().getTime());}
		
	
		}
	
	public Categoria insert(Categoria obj ) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
       }
	}
}
