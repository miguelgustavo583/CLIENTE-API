package com.fatec.clienteapi.controller;

import com.fatec.clienteapi.model.Venda;
import com.fatec.clienteapi.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    @PostMapping
    public Venda criarVenda(@RequestBody Venda venda) {
        return vendaService.criarVenda(venda);
    }

    @GetMapping
    public List<Venda> listarTodas() {
        return vendaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable String id) {
        Venda venda = vendaService.buscarPorId(id);
        if (venda == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(venda);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Venda> listarPorCliente(@PathVariable String clienteId) {
        return vendaService.listarPorCliente(clienteId);
    }
}