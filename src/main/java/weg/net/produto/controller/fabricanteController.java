package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.model.Fabricante;
import weg.net.produto.service.FabricanteService;

import java.util.List;

@RequestMapping("/fabricante")
@AllArgsConstructor
@RestController
public class fabricanteController {
    private final FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<Fabricante> cadastrar(@RequestBody Fabricante fabricante) {
        try {
            fabricanteService.cadastrar(fabricante);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            if (!fabricanteService.verificaParametros(fabricante)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Fabricante> editar(@RequestBody Fabricante fabricante) {
        try {
            fabricanteService.editar(fabricante);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> editar(@PathVariable Integer id) {
        try {
            fabricanteService.editar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        fabricanteService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(fabricanteService.buscarUm(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> buscarTodos() {
        return new ResponseEntity<>(fabricanteService.buscarTodos(), HttpStatus.OK);
    }
}
