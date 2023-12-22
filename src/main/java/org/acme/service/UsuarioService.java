package org.acme.service;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioResponseDTO;

import jakarta.validation.Valid;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO usuario);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public UsuarioResponseDTO findByNome(String nome);
    
    public UsuarioResponseDTO findByUserName(String nome);

    public List<UsuarioResponseDTO> findByAll();

}
