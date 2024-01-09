package org.acme.repository;

import java.util.List;

import org.acme.model.Cidade;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class CidadeRepository implements PanacheRepository<Cidade>{
    
    public List<Cidade> findByNome(String nome){
        return find("UPPER(nome) LIKE UPPER(?1)", "%" +nome+ "%").list();
    }
    
    
}
