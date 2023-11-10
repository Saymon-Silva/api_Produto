package weg.net.produto.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.net.produto.model.Produto;
import weg.net.produto.service.ProdutoService;

import java.util.List;

@RequestMapping("/produto")
@AllArgsConstructor
@RestController
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        try {
            produtoService.cadastrar(produto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            if (!produtoService.verificaSegundaEtapaAtributos(produto)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> editar(@RequestBody Produto produto) {
        try {
            produtoService.editar(produto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> editar(@PathVariable Integer id) {
        try {
            produtoService.editar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarUm(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(produtoService.buscarUm(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        return new ResponseEntity<>(produtoService.buscarTodos(), HttpStatus.OK);
    }
}