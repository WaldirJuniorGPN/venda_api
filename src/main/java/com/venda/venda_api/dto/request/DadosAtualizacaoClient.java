package com.venda.venda_api.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoClient(
        @NotNull
        Long id,
        String name
) {
}
