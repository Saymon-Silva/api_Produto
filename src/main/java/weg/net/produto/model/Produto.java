package weg.net.produto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private Long codigoBarras;
    @Column(nullable = false)
    private String nome;
    private Double preco;
    private Integer estoque;
    @Column(nullable = false)
    private String data;
    @Column(nullable = false)
    private Double peso;
    @Column(nullable = false)
    private Double medida;
    @Column(nullable = false)
    @ManyToOne
    private Fabricante fabricante;
    @Column(nullable = false)
    @ManyToOne
    private Categoria categoria;

}
