package com.pratica.produto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratica.produto.entity.Produto;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Long>{
 Optional<Produto> findByNomeIgnoreCase(String nome);
    
}