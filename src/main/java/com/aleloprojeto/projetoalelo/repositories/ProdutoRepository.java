package com.aleloprojeto.projetoalelo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aleloprojeto.projetoalelo.domain.Produto;

// Acesso a dados (Repository)
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {



}
