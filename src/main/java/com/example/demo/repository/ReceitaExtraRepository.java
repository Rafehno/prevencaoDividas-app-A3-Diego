package com.example.demo.repository;

import com.example.demo.entity.ReceitaExtra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaExtraRepository extends JpaRepository<ReceitaExtra, Long> {
    List<ReceitaExtra> findByClienteId(Long clienteId);
}