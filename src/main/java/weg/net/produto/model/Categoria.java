package weg.net.produto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Categoria {
    @Id
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> listaProdutos;
}
