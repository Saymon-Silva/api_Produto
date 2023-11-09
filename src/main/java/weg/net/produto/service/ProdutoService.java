package weg.net.produto.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.net.produto.model.Produto;
import weg.net.produto.repository.ProdutoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public void cadastrar(Produto produto) {
        if (validarProdutoPorCodigoBarras(produto)) {
            produtoRepository.save(produto);
        } else {
            Produto produtoOriginal = buscarProdutoPorCodigoBarras(produto);
            produtoOriginal.setEstoque(produtoOriginal.getEstoque() + 1);
            throw new RuntimeException("Já possui um produto com o codigo de barras: " + produto.getCodigoBarras() + "\n" +
                    "Será adicionado um novo item ao estoque do mesmo.");
        }
    }

    public void editar(Produto produto) {
        produtoRepository.save(produto);
    }

    public void editar(Integer id) {
        Produto produtoEdicao = buscarUm(id);
        produtoRepository.save(produtoEdicao);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto buscarUm(Integer id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public boolean validarProdutoPorCodigoBarras(Produto produto) {
        List<Produto> produtos = buscarTodos();
        for (Produto produtoFor : produtos) {
            if (produtoFor.getCodigoBarras() == produto.getCodigoBarras()) {
                return false;
            }
        }
        return true;
    }

    public Produto buscarProdutoPorCodigoBarras(Produto produto) {
        List<Produto> produtos = buscarTodos();
        for (Produto produtoFor : produtos) {
            if (produtoFor.getCodigoBarras() == produto.getCodigoBarras()) {
                return produtoFor;
            }
        }
        return null;
    }
    public boolean validacaoNomeNull(String nome){
        if(nome == null){
            return true;
        }
        return false;
    }
}
