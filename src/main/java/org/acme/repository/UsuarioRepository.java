package org.acme.repository;

import java.util.List;

import org.acme.model.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public Usuario findByLogin(String nome){
        try{
            return find("nome = ?1", nome).singleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }

    public Usuario findByLoginAndSenha(String login, String senha){
        try{
            return find("login =? AND senha = ?2", login, senha).singleResult();
        } catch(NoResultException e){
            e.printStackTrace();
            return null;
        }

    }

}
