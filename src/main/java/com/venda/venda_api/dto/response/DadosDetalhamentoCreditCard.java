package com.venda.venda_api.dto.response;

import com.venda.venda_api.model.CreditCard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record DadosDetalhamentoCreditCard(UUID id, BigDecimal value, Integer cvv, String cardHolderName,
                                          LocalDate expDate) {
    public DadosDetalhamentoCreditCard(CreditCard creditCard) {
        this(creditCard.getId(), creditCard.getValue(), creditCard.getCvv(), creditCard.getCardHolderName(), creditCard.getExpDate());
    }
}
