package com.example.demo.repository;

import com.example.demo.entity.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetaFinanceiraRepository extends JpaRepository<MetaFinanceira, Long> {
    List<MetaFinanceira> findByClienteId(Long clienteId);
}

