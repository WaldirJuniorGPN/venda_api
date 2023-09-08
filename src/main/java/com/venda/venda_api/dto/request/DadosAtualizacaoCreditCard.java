package com.venda.venda_api.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record DadosAtualizacaoCreditCard(
        @NotNull
        UUID id,
        @Min(0)
        BigDecimal value,
        @Digits(integer = 3, fraction = 0)
        Integer cvv,
        String cardHolderName,
        @Future
        LocalDate expDate
) {
}
