package weg.net.produto.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.net.produto.model.Fabricante;
import weg.net.produto.repository.FabricanteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    public void cadastrar(Fabricante fabricante){
        fabricanteRepository.save(fabricante);
    }
    public void editar(Fabricante fabricante){
        fabricanteRepository.save(fabricante);
    }
    public void editar(Integer id){
        Fabricante fabricanteEdicao = buscarUm(id);
        fabricanteRepository.save(fabricanteEdicao);
    }
    public void deletar(Integer id){
        fabricanteRepository.deleteById(id);
    }
    public Fabricante buscarUm(Integer id){
        return fabricanteRepository.findById(id).get();
    }
    public List<Fabricante> buscarTodos(){
        return fabricanteRepository.findAll();
    }
}
