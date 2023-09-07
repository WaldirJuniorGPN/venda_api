package com.venda.venda_api.dto.response;

import com.venda.venda_api.model.Client;

public record DadosListagemClient(Long id, String nome) {
    public DadosListagemClient(Client client) {
        this(client.getId(), client.getName());
    }
}
