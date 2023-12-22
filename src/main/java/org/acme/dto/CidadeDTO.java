package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(
        @NotBlank(message = "O campo não pode ser nulo.") String nome,
        Long idEstado

) {

}
