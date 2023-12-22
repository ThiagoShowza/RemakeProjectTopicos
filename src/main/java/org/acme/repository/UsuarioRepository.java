package org.acme.repository;

import java.util.List;

import org.acme.model.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.persistence.NoResultException;

public class UsuarioRepository implements PanacheRepository<Usuario> {
    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public Usuario findByUserName(String nome){
        try{
            return find("nome = ?1", nome ).singleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }

}
