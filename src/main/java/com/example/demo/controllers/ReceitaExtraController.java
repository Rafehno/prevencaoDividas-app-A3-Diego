package com.example.demo.controllers;

import com.example.demo.entity.ReceitaExtra;
import com.example.demo.repository.ReceitaExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaExtraController {
    @Autowired
    private ReceitaExtraRepository repo;

    @GetMapping
    public List<ReceitaExtra> listar() {
        return repo.findAll();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<ReceitaExtra> listarPorCliente(@PathVariable Long clienteId) {
        return repo.findByClienteId(clienteId);
    }

    @PostMapping
    public ReceitaExtra criar(@RequestBody ReceitaExtra r) {
        return repo.save(r);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}


