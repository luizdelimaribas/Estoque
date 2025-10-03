package com.pratica.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // retorna 404 para quando nao foi encontrado
public class RecursoNaoEncontradoException extends RuntimeException{

  public RecursoNaoEncontradoException (String mensagem){
    super(mensagem);
  }

}
