package com.venda.venda_api.repository;

import com.venda.venda_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
