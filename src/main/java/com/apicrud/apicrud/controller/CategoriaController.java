package com.apicrud.apicrud.controller;

import com.apicrud.apicrud.model.Categoria;
import com.apicrud.apicrud.model.Produto;
import com.apicrud.apicrud.model.ProdutoCategoria;
import com.apicrud.apicrud.model.ProdutoCategoriaPK;
import com.apicrud.apicrud.repository.CategoriaRepo;
import com.apicrud.apicrud.repository.ProdutoCategoriaRepo;
import com.apicrud.apicrud.repository.ProdutoRepo;
import com.apicrud.apicrud.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias", description = "Endpoints relacionadas à manipulação de categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Autowired
    private ProdutoRepo produtoRepo;

    @Autowired
    private ProdutoCategoriaRepo produtoCategoriaRepo;

    @PostConstruct
    public void testeTodos(){
        // CATEGORIAS
        Categoria cat1 = new Categoria();
        cat1.setNome("Eletrônicos");

        Categoria cat2 = new Categoria();
        cat2.setNome("Informática");

        categoriaRepo.saveAll(List.of(cat1, cat2));

        // PRODUTOS
        Produto p1 = new Produto();
        p1.setNome("Notebook Dell");
        p1.setPreco(new BigDecimal("3500.00"));

        Produto p2 = new Produto();
        p2.setNome("Mouse Gamer");
        p2.setPreco(new BigDecimal("150.00"));

        produtoRepo.saveAll(List.of(p1, p2));

        ProdutoCategoria rel1 = new ProdutoCategoria(new ProdutoCategoriaPK(p1.getId(), cat1.getId()));
        ProdutoCategoria rel2 = new ProdutoCategoria(new ProdutoCategoriaPK(p1.getId(), cat2.getId()));
        ProdutoCategoria rel3 = new ProdutoCategoria(new ProdutoCategoriaPK(p2.getId(), cat1.getId()));

        produtoCategoriaRepo.saveAll(List.of(rel1, rel2, rel3));

        produtoCategoriaRepo.saveAll(List.of(rel1, rel2, rel3));
    }

    @Operation(summary = "Lista todas as categorias", description = "Retorna todas as categorias disponíveis.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria adquiridas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return ResponseEntity.ok().body(categoriaService.listarTodos());
    }

    @Operation(summary = "Cadastra nova categoria", description = "Cria uma nova categoria.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria dto) {
        Categoria categoria = categoriaService.criar(dto);
        return new ResponseEntity<>(categoriaService.criar(dto), HttpStatus.CREATED); //Usar esse Response pq o estático pede URI no .created()
    }






}
