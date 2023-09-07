package com.venda.venda_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Table(name = "cartoes")
@Entity(name = "CreditCard")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreditCard {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private BigDecimal value;
    private Integer cvv;
    private String cardHolderName;
    private LocalDate expDate;
}
