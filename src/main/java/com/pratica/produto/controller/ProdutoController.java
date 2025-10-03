package com.pratica.produto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.produto.dto.DTOProduto;
import com.pratica.produto.entity.Produto;
import com.pratica.produto.service.ServiceProduto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ServiceProduto service;

    public ProdutoController(ServiceProduto service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody DTOProduto dto){
        Produto novoProduto = service.cadastrar(dto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping("/listaProdutos")
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> produtos = service.buscarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Produto> buscarId(@PathVariable Long id){
     Produto produto = service.buscarId(id);
     return ResponseEntity.ok(produto);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> buscarNome(@PathVariable String nome){
        Produto produto = service.buscarNome(nome);
        return ResponseEntity.ok(produto);
    }
}
