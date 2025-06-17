package com.example.demo.controllers;

import com.example.demo.entity.MetaFinanceira;
import com.example.demo.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaFinanceiraController {
    @Autowired
    private MetaFinanceiraRepository repo;

    @GetMapping
    public List<MetaFinanceira> listar() {
        return repo.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<MetaFinanceira> listarPorCliente(@PathVariable Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @PostMapping
    public MetaFinanceira criar(@RequestBody MetaFinanceira m) {
        return repo.save(m);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
