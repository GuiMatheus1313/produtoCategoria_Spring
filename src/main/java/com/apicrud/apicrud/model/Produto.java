package com.apicrud.apicrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull(message = "Nome não pode vir vazio")
        @Size(max = 50)
        private String nome;

        @DecimalMax(value = "10000.0")
        private BigDecimal preco;

        public Produto() {
        }

        public Produto(Long id, String nome, BigDecimal preco) {
                this.id = id;
                this.nome = nome;
                this.preco = preco;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public @NotNull(message = "Nome não pode vir vazio") @Size(max = 50) String getNome() {
                return nome;
        }

        public void setNome(@NotNull(message = "Nome não pode vir vazio") @Size(max = 50) String nome) {
                this.nome = nome;
        }

        public @DecimalMax(value = "10000.0") BigDecimal getPreco() {
                return preco;
        }

        public void setPreco(@DecimalMax(value = "10000.0") BigDecimal preco) {
                this.preco = preco;
        }
}
