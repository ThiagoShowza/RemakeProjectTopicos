package org.acme.dto;

import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String userName,
        String senha,
        Perfil perfil) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getUserName(),
                usuario.getSenha(),
                usuario.getPerfil());

    }

}
