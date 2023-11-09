package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.model.Fabricante;
import weg.net.produto.repository.FabricanteRepository;
import weg.net.produto.service.FabricanteService;

import java.util.List;

@RequestMapping("/fabricante")
@AllArgsConstructor
@Controller
public class fabricanteController {
    private final FabricanteService fabricanteService;

    @PostMapping
    public void cadastrar(@RequestBody Fabricante fabricante) {
        fabricanteService.cadastrar(fabricante);
    }

    @PutMapping
    public void editar(@RequestBody Fabricante fabricante) {
        fabricanteService.editar(fabricante);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Integer id) {
        fabricanteService.editar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        fabricanteService.deletar(id);
    }

    @GetMapping("/{id}")
    public Fabricante buscarUm(@PathVariable Integer id) {
        return fabricanteService.buscarUm(id);
    }

    @GetMapping
    public List<Fabricante> buscarTodos() {
        return fabricanteService.buscarTodos();
    }
}
