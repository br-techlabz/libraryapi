package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    //JPQL -> faz referencia as entidades e suas propriedades
    @Query(" select l from Livro l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloePreco();



    /**
     * select distinct a.*
     * from autor a
     * join livro l on a.id = l.id_autor
     */
    @Query(" select a from Livro l join l.autor a ")
    List<Autor> listarAutorDosLivros();


    @Query("""
        select l.genero
            from Livro l
            join l.autor a
            where a.nacionalidade = 'Brasileira'
            order by l.genero
    """)
    List<String> listarGenerosDeAutoresBrasileiros();


}
