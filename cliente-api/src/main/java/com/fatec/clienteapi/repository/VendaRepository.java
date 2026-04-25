package com.fatec.clienteapi.repository;

import com.fatec.clienteapi.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
    List<Venda> findByClienteId(String clienteId);
}