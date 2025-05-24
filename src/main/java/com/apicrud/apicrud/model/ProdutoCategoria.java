package com.apicrud.apicrud.model;

import jakarta.persistence.*;

@Entity
public class ProdutoCategoria {

    @EmbeddedId
    private ProdutoCategoriaPK produtocategoriaPK;

    public ProdutoCategoria() {
    }

    public ProdutoCategoria(ProdutoCategoriaPK produtocategoriaPK) {
        this.produtocategoriaPK = produtocategoriaPK;
    }

    public ProdutoCategoriaPK getProdutocategoriaPK() {
        return produtocategoriaPK;
    }

    public void setProdutocategoriaPK(ProdutoCategoriaPK produtocategoriaPK) {
        this.produtocategoriaPK = produtocategoriaPK;
    }
}
