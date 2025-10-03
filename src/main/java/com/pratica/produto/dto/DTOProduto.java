package com.pratica.produto.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOProduto {


    @NotBlank  //só funciona em String
    @Size(min = 3 , max = 20 , message = "Nome deve ter no maximo 20 caracteres")
    private String nome;

    @NotNull(message = "Valor não pode ser nulo")
    @Positive(message = "Valor tem que ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "Valor não pode ser nulo")
    @PositiveOrZero
    private long quantidade;
}
