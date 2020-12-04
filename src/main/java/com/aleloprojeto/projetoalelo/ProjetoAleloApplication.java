package com.aleloprojeto.projetoalelo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetoAleloApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAleloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
          Categoria cat1 = new Categoria(null, "Minha Empresa");
          Categoria cat2 = new Categoria(null, "Meu Cartão");
		
          categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}


