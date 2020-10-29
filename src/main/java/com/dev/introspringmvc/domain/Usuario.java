package com.dev.introspringmvc.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Usuario {

    private Long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nome;
    @NotEmpty
    @Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres.")
    private String sobrenome;

    @NotNull(message = "O campo data de nascimento é requerido")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dtNascimento;

    private TipoSexo sexo;

    public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento, TipoSexo sexo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dtNascimento = dtNascimento;
        this.sexo = sexo;
    }
}
