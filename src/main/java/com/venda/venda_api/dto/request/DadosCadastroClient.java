package com.venda.venda_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroClient(
        @NotBlank
        String name
) {
}
