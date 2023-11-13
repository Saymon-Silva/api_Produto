package weg.net.produto.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.net.produto.exception.ExceptionDadosFaltantes;
import weg.net.produto.model.Fabricante;
import weg.net.produto.repository.FabricanteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    public void cadastrar(Fabricante fabricante) {
        try {
            verificaParametros(fabricante);
            fabricanteRepository.save(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editar(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
    }

    public void editar(Integer id) {
        Fabricante fabricanteEdicao = buscarUm(id);
        fabricanteRepository.save(fabricanteEdicao);
    }

    public void deletar(Integer id) {
        fabricanteRepository.deleteById(id);
    }

    public Fabricante buscarUm(Integer id) {
        return fabricanteRepository.findById(id).get();
    }

    public List<Fabricante> buscarTodos() {
        return fabricanteRepository.findAll();
    }

    public boolean verificarNomeNull(Fabricante fabricante) {
        if (fabricante.getNome() == null) {
            return true;
        }
        return false;
    }

    public boolean verificaParametros(Fabricante fabricante) {
        if (verificarNomeNull(fabricante)) {
            throw new ExceptionDadosFaltantes("O nome é um atributo obrigatorio!");
        }
        return true;
    }
//    public boolean verificaSegundaEtapaAtributos(Fabricante fabricante){
//        try{
//            verificaParametros(fabricante);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
}
