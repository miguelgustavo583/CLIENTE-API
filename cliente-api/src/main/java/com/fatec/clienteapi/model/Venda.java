package com.fatec.clienteapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "vendas")
public class Venda {

    @Id
    private String id;
    private String clienteId;
    private String nomeCliente;
    private List<ItemVenda> itens;
    private Double total;
    private LocalDateTime dataVenda;
}