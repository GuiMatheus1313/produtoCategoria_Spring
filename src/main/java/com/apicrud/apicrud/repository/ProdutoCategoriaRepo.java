package com.apicrud.apicrud.repository;

import com.apicrud.apicrud.model.ProdutoCategoria;
import com.apicrud.apicrud.model.ProdutoCategoriaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCategoriaRepo extends JpaRepository<ProdutoCategoria, ProdutoCategoriaPK> {
}
