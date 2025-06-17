package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired private ClienteRepository repo;

    @GetMapping public List<Cliente> listar() { return repo.findAll(); }

    @PostMapping public Cliente criar(@RequestBody Cliente c) { return repo.save(c); }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente novo) {
        Cliente cliente = repo.findById(id).orElseThrow();
        cliente.setNome(novo.getNome());
        cliente.setCpf(novo.getCpf());
        cliente.setRendaMensal(novo.getRendaMensal());
        return repo.save(cliente);
    }

    @PatchMapping("/{id}")
    public Cliente patchRenda(@PathVariable Long id, @RequestBody Double novaRenda) {
        Cliente cliente = repo.findById(id).orElseThrow();
        cliente.setRendaMensal(novaRenda);
        return repo.save(cliente);
    }

    @DeleteMapping("/{id}") public void deletar(@PathVariable Long id) { repo.deleteById(id); }
}

