package org.acme.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends DefaultEntity {

    private Usuario usuario;
    private Cidade cidade;
    private Long cep;
    private String bairro;
    private String quadra;
    private String rua;
    private Long numero;
}