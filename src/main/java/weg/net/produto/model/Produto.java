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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
