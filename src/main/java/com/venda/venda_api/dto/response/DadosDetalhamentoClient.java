package com.venda.venda_api.dto.response;

import com.venda.venda_api.model.Client;

public record DadosDetalhamentoClient(Long id, String nome) {
    public DadosDetalhamentoClient(Client client) {
        this(client.getId(), client.getName());
    }
}
