package com.apicrud.apicrud.service;

import com.apicrud.apicrud.model.Categoria;
import com.apicrud.apicrud.repository.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepo categoriaRepo;

    public Categoria criar(Categoria model){
        return categoriaRepo.save(model);
    }

    public List<Categoria> listarTodos(){
        return categoriaRepo.findAll();
    }

}
