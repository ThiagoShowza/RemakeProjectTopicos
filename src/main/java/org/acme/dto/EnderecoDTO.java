package org.acme.dto;


public record EnderecoDTO(
    Long idUsuario,
    Long idCidade,
    Long cep,
    String bairro,
    String quadra,
    String rua,
    Long numero
) {
    
}
