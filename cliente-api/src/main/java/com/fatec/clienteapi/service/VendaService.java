package com.fatec.clienteapi.service;

import com.fatec.clienteapi.model.Venda;
import com.fatec.clienteapi.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteService clienteService;

    public Venda criarVenda(Venda venda) {
        // Busca o cliente e preenche o nome
        clienteService.buscarPorId(venda.getClienteId())
                .ifPresent(cliente -> venda.setNomeCliente(cliente.getNome()));

        // Calcula o total
        double total = venda.getItens().stream()
                .mapToDouble(item -> item.getQuantidade() * item.getPrecoUnitario())
                .sum();

        venda.setTotal(total);
        venda.setDataVenda(LocalDateTime.now());

        return vendaRepository.save(venda);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public List<Venda> listarPorCliente(String clienteId) {
        return vendaRepository.findByClienteId(clienteId);
    }

    public Venda buscarPorId(String id) {
        return vendaRepository.findById(id).orElse(null);
    }
}