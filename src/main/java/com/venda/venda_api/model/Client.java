package com.venda.venda_api.model;

import com.venda.venda_api.dto.request.DadosAtualizacaoClient;
import com.venda.venda_api.dto.request.DadosCadastroClient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Client")
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Transaction> transaction;

    public Client(DadosCadastroClient dados) {
        this.name = dados.name();
    }

    public void atualizarDados(DadosAtualizacaoClient dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
    }
}
