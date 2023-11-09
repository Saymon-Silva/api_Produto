package weg.net.produto.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.net.produto.model.Categoria;
import weg.net.produto.repository.CategoriaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public void cadastrar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void editar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
    public void editar(Integer id){
        Categoria categoriaEdicao = buscarUm(id);
        categoriaRepository.save(categoriaEdicao);
    }

    public void deletar(Integer id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarUm(Integer id) {
        return categoriaRepository.findById(id).get();
    }

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
}
