package org.acme.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cidade extends DefaultEntity {

    private String nome;
    private Estado estado;

}
