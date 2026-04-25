package com.fatec.clienteapi.model;

import lombok.Data;

@Data
public class ItemVenda {
    private String produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;
}