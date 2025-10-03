package com.pratica.produto.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(unique = true, nullable = false)
    private String nome;

    /* números decimais a precisão total será de 10 dígitos,
    sendo que 2 desses dígitos devem ser após a vírgula (precision = 10, scale = 2). */
    @Column(nullable = false, precision = 10, scale = 2) 
    private BigDecimal valor;

    @Column(nullable = false)
    private long quantidade;

}
