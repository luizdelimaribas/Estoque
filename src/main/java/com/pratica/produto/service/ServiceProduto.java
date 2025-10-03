package com.pratica.produto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pratica.produto.dto.DTOProduto;
import com.pratica.produto.entity.Produto;
import com.pratica.produto.exception.JaExisteException;
import com.pratica.produto.exception.RecursoNaoEncontradoException;
import com.pratica.produto.repository.RepositoryProduto;

@Service
public class ServiceProduto {

 private final RepositoryProduto repository;

 public ServiceProduto(RepositoryProduto repository) {
    this.repository = repository;
 }

 public Produto cadastrar(DTOProduto dto){
    String nomeMinusculo = dto.getNome().toLowerCase();
    if (repository.findByNomeIgnoreCase(nomeMinusculo).isPresent()) {
        throw new JaExisteException("Nome ja cadastrado");
    }

    Produto produto = new Produto();
    produto.setNome(nomeMinusculo);
    produto.setQuantidade(dto.getQuantidade());
    produto.setValor(dto.getValor());
    return repository.saveAndFlush(produto);
 }

 public List<Produto> buscarTodos(){
    return repository.findAll();
 }

 public Produto buscarId(Long id){
  return repository.findById(id)
  .orElseThrow(() -> new RecursoNaoEncontradoException("O produto com ID:" + id + " não encontrado."));
 }

 public Produto buscarNome(String nome){
    return repository.findByNomeIgnoreCase(nome)
    .orElseThrow(() -> new RecursoNaoEncontradoException("O produto com nome:" + nome + " não encontrado."));
 }


}
