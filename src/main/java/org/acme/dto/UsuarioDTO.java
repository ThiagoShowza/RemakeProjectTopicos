package org.acme.dto;

public record UsuarioDTO (
    String nome,
    String login,
    String senha,
    Integer idPerfil
){
    
}
