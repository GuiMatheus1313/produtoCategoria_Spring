package com.apicrud.apicrud.repository;

import com.apicrud.apicrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Long> {
}
