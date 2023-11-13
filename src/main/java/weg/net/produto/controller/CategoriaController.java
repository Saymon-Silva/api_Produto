package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.exception.ExceptionConflito;
import weg.net.produto.model.Categoria;
import weg.net.produto.service.CategoriaService;
import weg.net.produto.exception.ExceptionDadosFaltantes;

import java.util.List;

@RequestMapping("/categoria")
@AllArgsConstructor
@RestController
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {
        try {
            categoriaService.cadastrar(categoria);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ExceptionDadosFaltantes e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ExceptionConflito e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Categoria> editar(@RequestBody Categoria categoria) {
        try {
            categoriaService.editar(categoria);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable Integer id) {
        try {
            categoriaService.editar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        categoriaService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(categoriaService.buscarUm(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos() {
        return new ResponseEntity<>(categoriaService.buscarTodos(), HttpStatus.OK);
    }
}
