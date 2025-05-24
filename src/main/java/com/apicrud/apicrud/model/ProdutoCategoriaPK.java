package com.apicrud.apicrud.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

@Embeddable
public class ProdutoCategoriaPK {
    private Long produtoId;

    private Long categoriaId;

    public ProdutoCategoriaPK() {
    }

    public ProdutoCategoriaPK(Long produtoId, Long categoriaId) {
        this.produtoId = produtoId;
        this.categoriaId = categoriaId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
