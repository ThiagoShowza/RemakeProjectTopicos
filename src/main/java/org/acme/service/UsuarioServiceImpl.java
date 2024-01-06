package org.acme.service;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.ForbiddenException;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;
import org.acme.model.Perfil;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.validation.ValidationException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Inject
    HashService hashService;

    @Inject
    JsonWebToken jwt;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {
        if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("Login", "Login já existe");

        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setLogin(dto.login());
        novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));

        novoUsuario.setPerfil(Perfil.valueOf(dto.idPerfil()));

        repository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);

    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto, Long id) {
    
        String loginUsuarioLogado = jwt.getSubject();

        Usuario usuarioLogado = repository.findByLogin(loginUsuarioLogado);
        if(usuarioLogado == null || (usuarioLogado.getPerfil() != Perfil.ADMIN && !usuarioLogado.getId().equals(id))){
            throw new ForbiddenException("Você não tem permissão para atualizar este usuário.");
        }

        Usuario updateUsuario = repository.findById(id);
        updateUsuario.setLogin(dto.login());
        updateUsuario.setNome(dto.nome());
        updateUsuario.setSenha(dto.senha());

        return UsuarioResponseDTO.valueOf(updateUsuario);
    }

    @Override
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new NotFoundException();
        }
    }

    @Override
    @Transactional
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null)
            throw new ValidationException("login", "Login ou senha inválidos");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {

        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> usuarios = repository.find("UPPER(login) LIKE UPPER(?1)", "%" + nome + "%").list();

        return usuarios.stream()
                .map(UsuarioResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByLogin(String login) {
        List<Usuario> usuario = repository.find("UPPER(login)", "%" + login + "%").list();

        return usuario.stream()
                .map(UsuarioResponseDTO::valueOf)
                .toList();
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }


}