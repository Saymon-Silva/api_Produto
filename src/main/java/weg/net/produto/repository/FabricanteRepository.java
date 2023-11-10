package weg.net.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weg.net.produto.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {
}