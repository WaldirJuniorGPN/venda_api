package com.venda.venda_api.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroCreditCard(
        @NotNull
        @Min(0)
        BigDecimal value,
        @NotNull
        @Digits(integer = 3, fraction = 0)
        Integer cvv,
        @NotBlank
        String cardHolderName,
        @NotNull
        @Future
        LocalDate expDate
) {
}
