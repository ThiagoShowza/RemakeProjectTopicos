package org.acme.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends DefaultEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;
    private Long cep;
    private String bairro;
    private String quadra;
    private String rua;
    private Long numero;
}