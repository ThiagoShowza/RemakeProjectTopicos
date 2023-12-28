package org.acme.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class DefaultEntity {

    @Id // Indica a chave primaria da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Define que o valor de id será gerado pelo banco de dados sendo unico e
    // sequencial
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
