package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.model.Categoria;
import weg.net.produto.service.CategoriaService;

import java.util.List;

@RequestMapping("/categoria")
@AllArgsConstructor
@Controller
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public void cadastrar(@RequestBody Categoria categoria) {
        categoriaService.cadastrar(categoria);
    }

    @PutMapping
    public void editar(@RequestBody Categoria categoria) {
        categoriaService.editar(categoria);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Integer id) {
        categoriaService.editar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        categoriaService.deletar(id);
    }

    @GetMapping("/{id}")
    public Categoria buscarUm(@PathVariable Integer id) {
        return categoriaService.buscarUm(id);
    }

    @GetMapping
    public List<Categoria> buscarTodos() {
        return categoriaService.buscarTodos();
    }
}
