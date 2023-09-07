package com.venda.venda_api.controller;

import com.venda.venda_api.dto.request.DadosAtualizacaoClient;
import com.venda.venda_api.dto.request.DadosCadastroClient;
import com.venda.venda_api.dto.response.DadosDetalhamentoClient;
import com.venda.venda_api.dto.response.DadosListagemClient;
import com.venda.venda_api.model.Client;
import com.venda.venda_api.repository.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroClient dados, UriComponentsBuilder uriComponentsBuilder) {
        var client = new Client(dados);
        repository.save(client);
        var uri = uriComponentsBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoClient(client));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemClient>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemClient::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoClient dados) {
        var client = repository.getReferenceById(dados.id());
        client.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
