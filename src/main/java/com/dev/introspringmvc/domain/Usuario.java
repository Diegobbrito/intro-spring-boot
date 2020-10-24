package com.dev.introspringmvc.domain;

import lombok.Data;

@Data
public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;

    public Usuario(Long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Usuario() {
        super();
    }
}
