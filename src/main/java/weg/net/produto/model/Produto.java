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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    private Integer estoque;

    @Column(nullable = false)
    private String dataValidade;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Long codigoBarras;

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
