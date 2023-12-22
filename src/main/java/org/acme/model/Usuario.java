package org.acme.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario extends DefaultEntity {

    private String nome;
    private String userName;
    private String senha;
    private Perfil perfil;

}