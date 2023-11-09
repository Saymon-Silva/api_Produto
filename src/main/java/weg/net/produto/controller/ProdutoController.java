package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.model.Produto;
import weg.net.produto.service.ProdutoService;

import java.util.List;

@RequestMapping("/produto")
@AllArgsConstructor
@Controller
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public void cadastrar(@RequestBody Produto produto) {
        produtoService.cadastrar(produto);
    }

    @PutMapping
    public void editar(@RequestBody Produto produto) {
        produtoService.editar(produto);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Integer id) {
        produtoService.editar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
    }

    @GetMapping("/{id}")
    public Produto buscarUm(@PathVariable Integer id) {
        return produtoService.buscarUm(id);
    }

    @GetMapping
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }
}