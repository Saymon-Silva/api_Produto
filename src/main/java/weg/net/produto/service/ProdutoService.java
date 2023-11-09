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
        if (validacaoNomeNull(produto)) {
            throw new RuntimeException("É necessaria a inserção de um nome!");
        }
        if (validacaoPrecoMaiorZero(produto)) {
            if (produto.getPreco() <= 0) {
                throw new RuntimeException("O produto não pode possuir preço negativo!");
            }
            throw new RuntimeException("O produto obrigatoriamente precisa possuir preço!");
        }
        if (validacaoDataValidadeNull(produto)) {
            throw new RuntimeException("O produto obrigatoriamente precisa possuir data de validade!");
        }
        if (validacaoDescricaoNull(produto)) {
            throw new RuntimeException("O produto obrigatoriamente precisa possuir descrição");
        }
        if (validacaoPesoMaioZero(produto)) {
            if (produto.getPeso() <= 0) {
                throw new RuntimeException("O produto não pode possuir peso negativo!");
            }
            throw new RuntimeException("O produto obrigatoriamente precisa possuir peso!");
        }
        if (validacaoMedidaMaioZero(produto)){
            if (produto.getMedida() <= 0) {
                throw new RuntimeException("O produto não pode possuir medida negativa!");
            }
            throw new RuntimeException("O produto obrigatoriamente precisa possuir medida!");
        }
        if(validacaoFabricanteNull(produto)){
            throw new RuntimeException("O produto obrigatoriamente precisa ter informações sobre seu fabricante!");
        }
        if(validacaoCategoriaNull(produto)){
            throw new RuntimeException("O produto obrigatoriamente precisa ter informações sobre sua categoria!");
        }
        if(validacaoCodigoBarraNull(produto)){
            throw new RuntimeException("O produto obrigatoriamente precisa possuir codigo de barra!");
        }
            if (validarProdutoPorCodigoBarras(produto)) {
                produtoRepository.save(produto);
                produto.setEstoque(produto.getEstoque() + 1);
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

    public boolean validacaoNomeNull(Produto produto) {
        if (produto.getNome() == null) {
            return true;
        }
        return false;
    }

    public boolean validacaoPrecoMaiorZero(Produto produto) {
        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            return true;
        }
        return false;
    }

    public boolean validacaoDataValidadeNull(Produto produto) {
        if (produto.getDataValidade() == null) {
            return true;
        }
        return false;
    }

    public boolean validacaoDescricaoNull(Produto produto) {
        if (produto.getDescricao() == null) {
            return true;
        }
        return false;
    }

    public boolean validacaoCodigoBarraNull(Produto produto) {
        if (produto.getCodigoBarras() == null) {
            return true;
        }
        return false;
    }

    public boolean validacaoPesoMaioZero(Produto produto) {
        if (produto.getPeso() == null || produto.getPeso() <= 0) {
            return true;
        }
        return false;
    }

    public boolean validacaoMedidaMaioZero(Produto produto) {
        if (produto.getMedida() == null || produto.getMedida() <= 0) {
            return true;
        }
        return false;
    }

    public boolean validacaoFabricanteNull(Produto produto) {
        if (produto.getFabricante() == null) {
            return true;
        }
        return false;
    }

    public boolean validacaoCategoriaNull(Produto produto) {
        if (produto.getCategoria() == null) {
            return true;
        }
        return false;
    }
}
