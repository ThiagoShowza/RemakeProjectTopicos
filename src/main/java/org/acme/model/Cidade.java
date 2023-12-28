package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cidade extends DefaultEntity {



    private String nome;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

}
