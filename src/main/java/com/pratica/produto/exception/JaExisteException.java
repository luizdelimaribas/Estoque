package com.pratica.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // retorna 409 para quando ja existe
public class JaExisteException extends RuntimeException{

 public JaExisteException(String mensagem){
    super (mensagem);
 }

}
