package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Emprestimo {
    @Id @GeneratedValue
    private Long id;

    private String banco;
    private Double valorEmprestado;
    private Double taxaJuros;
    private Integer parcelas;

    @ManyToOne
    private Cliente cliente;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBanco() { return banco; }
    public void setBanco(String banco) { this.banco = banco; }

    public Double getValorEmprestado() { return valorEmprestado; }
    public void setValorEmprestado(Double valorEmprestado) { this.valorEmprestado = valorEmprestado; }

    public Double getTaxaJuros() { return taxaJuros; }
    public void setTaxaJuros(Double taxaJuros) { this.taxaJuros = taxaJuros; }

    public Integer getParcelas() { return parcelas; }
    public void setParcelas(Integer parcelas) { this.parcelas = parcelas; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}