package com.fatec.clienteapi.service;

import com.fatec.clienteapi.model.Cliente;
import com.fatec.clienteapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(String id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(String id, Cliente clienteAtualizado) {
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    public void deletar(String id) {
        clienteRepository.deleteById(id);
    }
}