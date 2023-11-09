package weg.net.produto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Fabricante {
    @Id
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "fabricante")
    @JsonIgnore
    private List<Produto> estoqueProdutos;
}
