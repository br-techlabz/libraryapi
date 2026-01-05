package br.techlabz.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Getter
@Setter
public class Livro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;

    @Column(nullable = false, length = 20)
    private String isbn;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column
    private String genero;

    @Column(precision = 18, scale = 2)
    private Double preco;

    @JoinColumn(name = "id_autor")
    @ManyToOne
    private Autor autor;
}
