package weg.net.produto.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.net.produto.model.Categoria;
import weg.net.produto.repository.CategoriaRepository;

import java.util.List;

@AllArgsConstructor

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public void cadastrar(Categoria categoria) {
        try {
            verificaParametros(categoria);
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void editar(Integer id) {
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

    public boolean verificarNomeNull(Categoria categoria) {
        if (categoria.getNome() == null) {
            return true;
        }
        return false;
    }

    public boolean verificaParametros(Categoria categoria) {
        if (verificarNomeNull(categoria)) {
            throw new RuntimeException("O nome é um atributo obrigatorio!");
        }
        return true;
    }

//    public boolean verificaSegundaEtapaAtributos(Categoria categoria){
//        try{
//            verificaParametros(categoria);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }


//    public boolean buscarCategoria(Categoria categoria){
//        if (buscarUm(categoria.getId()) != null){
//            return true;
//        }
//        return false;
//    }
}
