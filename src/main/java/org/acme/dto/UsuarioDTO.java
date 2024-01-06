package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO (
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    String login,
    String senha,
    Integer idPerfil
){
    
}
