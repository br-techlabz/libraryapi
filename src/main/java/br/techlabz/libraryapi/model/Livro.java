package br.techlabz.libraryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20, nullable = false)
    private String isbn;

    @Column(length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(precision = 18, scale = 2)
    private Double preco;

    @Enumerated(EnumType.STRING)
    @Column(name="genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;


}
