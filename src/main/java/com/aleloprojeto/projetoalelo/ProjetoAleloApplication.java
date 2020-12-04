package com.aleloprojeto.projetoalelo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aleloprojeto.projetoalelo.domain.Categoria;
import com.aleloprojeto.projetoalelo.domain.Produto;
import com.aleloprojeto.projetoalelo.repositories.CategoriaRepository;
import com.aleloprojeto.projetoalelo.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoAleloApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAleloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
          Categoria cat1 = new Categoria(null, "Benefícios e Incentivos");
          Categoria cat2 = new Categoria(null, "Gestão de Despesas Corporativas");
          
          Produto p1 = new Produto(null, "Alelo Refeição", 200000.00);
          Produto p2 = new Produto(null, "Alelo Alimentação", 200000.00);
          Produto p3 = new Produto(null, "Alelo Cultura", 100000.00);
          Produto p4 = new Produto(null, "Alelo Natal", 100000.00);
          Produto p5 = new Produto(null, "Alelo MultiBenefícios", 100000.00);
          Produto p6 = new Produto(null, "Alelo Mobilidade", 100000.00);
          Produto p7 = new Produto(null, "Alelo Premiação", 100000.00);
          
          Produto p8 = new Produto(null, "Alelo Frota", 100000.00);
          Produto p9 = new Produto(null, "Alelo Gestão de VT", 100000.00);
          Produto p10 = new Produto(null, "Alelo Pagamentos", 100000.00);
          Produto p11 = new Produto(null, "Alelo Despesas", 100000.00);
          
          cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
          cat2.getProdutos().addAll(Arrays.asList(p8, p9, p10, p11));
          
          p1.getCategorias().addAll(Arrays.asList(cat1));
          p2.getCategorias().addAll(Arrays.asList(cat1));
          p3.getCategorias().addAll(Arrays.asList(cat1));
          p4.getCategorias().addAll(Arrays.asList(cat1));
          p5.getCategorias().addAll(Arrays.asList(cat1));
          p6.getCategorias().addAll(Arrays.asList(cat1));
          p7.getCategorias().addAll(Arrays.asList(cat1));
          
          p8.getCategorias().addAll(Arrays.asList(cat2));
          p9.getCategorias().addAll(Arrays.asList(cat2));
          p10.getCategorias().addAll(Arrays.asList(cat2));
          p11.getCategorias().addAll(Arrays.asList(cat2));
          
          
          categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
          produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)); 
	}

}


