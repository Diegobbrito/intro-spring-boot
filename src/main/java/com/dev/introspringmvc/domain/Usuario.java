package com.dev.introspringmvc.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dtNascimento;

    public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
    }
}
