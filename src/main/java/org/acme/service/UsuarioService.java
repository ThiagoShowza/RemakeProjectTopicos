package org.acme.service;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;

import jakarta.validation.Valid;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);
    
    public List<UsuarioResponseDTO> findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll();

}
