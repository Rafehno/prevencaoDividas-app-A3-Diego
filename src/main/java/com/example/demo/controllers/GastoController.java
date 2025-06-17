package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Gasto;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.GastoRepository;

@RestController
@RequestMapping("/gastos")
public class GastoController {
    @Autowired private GastoRepository repo;
    @Autowired private ClienteRepository clienteRepo;

    @GetMapping("/cliente/{clienteId}")
    public List<Gasto> listarPorCliente(@PathVariable Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @PostMapping
    public Gasto criar(@RequestBody Gasto g) {
        return repo.save(g);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

