package org.acme.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends DefaultEntity {

    private Usuario nomeUsuario;
    private String bairro;
    private String quadra;
    private String rua;
    private long numero;
}