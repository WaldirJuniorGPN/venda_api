package com.venda.venda_api.controller;

import com.venda.venda_api.dto.request.DadosAtualizacaoCreditCard;
import com.venda.venda_api.dto.request.DadosCadastroCreditCard;
import com.venda.venda_api.dto.response.DadosDetalhamentoCreditCard;
import com.venda.venda_api.dto.response.DadosListagemCreditCard;
import com.venda.venda_api.model.CreditCard;
import com.venda.venda_api.repository.CreditCardRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCreditCard dados, UriComponentsBuilder uriComponentsBuilder) {
        var creditCard = new CreditCard(dados);
        repository.save(creditCard);
        var uri = uriComponentsBuilder.path("/credit-card/{id}").buildAndExpand(creditCard.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCreditCard(creditCard));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCreditCard>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemCreditCard::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCreditCard dados) {
        var creditCard = repository.getReferenceById(dados.id());
        creditCard.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCreditCard(creditCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable UUID id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
