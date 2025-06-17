package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
    List<Gasto> findByClienteId(Long clienteId);
}
