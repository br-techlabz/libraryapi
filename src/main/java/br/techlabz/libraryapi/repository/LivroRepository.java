package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    //Query Method
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndIsbn(String titulo, String isbn);

    List<Livro> findByDataPublicacaoBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Livro> findByTituloLike(String titulo);

    List<Livro> findByTituloStartingWith(String titulo);

    List<Livro> findByDataPublicacaoBetweenOrderByDataPublicacao(LocalDate dataInicial, LocalDate dataFinal);


}
