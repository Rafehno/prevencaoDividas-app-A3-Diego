package com.example.demo.controllers;

import com.example.demo.entity.Emprestimo;
import com.example.demo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repo;

    @GetMapping
    public List<Emprestimo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Emprestimo criar(@RequestBody Emprestimo e) {
        return repo.save(e);
    }
    @PutMapping("/{id}")
    public Emprestimo atualizar(@PathVariable Long id, @RequestBody Emprestimo novo) {
        Emprestimo e = repo.findById(id).orElseThrow();
        e.setBanco(novo.getBanco());
        e.setValorEmprestado(novo.getValorEmprestado());
        e.setTaxaJuros(novo.getTaxaJuros());
        e.setParcelas(novo.getParcelas());
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
