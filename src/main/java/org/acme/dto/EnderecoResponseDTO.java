package org.acme.dto;

import org.acme.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        UsuarioResponseDTO usuario,
        CidadeResponseDTO cidade,
        Long cep,
        String bairro,
        String quadra,
        String rua,
        Long numero) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getId(),
                UsuarioResponseDTO.valueOf(endereco.getUsuario()),
                CidadeResponseDTO.valueOf(endereco.getCidade()),
                endereco.getCep(),
                endereco.getBairro(),
                endereco.getQuadra(),
                endereco.getRua(),
                endereco.getNumero());

    }
}