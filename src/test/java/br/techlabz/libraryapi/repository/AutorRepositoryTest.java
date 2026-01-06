package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.GeneroLivro;
import br.techlabz.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private LivroRepository livroRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Dirce Silveira");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1985, 1, 26));
        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    void atualizarTest(){
        UUID id = UUID.fromString("d25ef0a8-d0c3-46d9-b893-05551ac3829e");
        Optional<Autor> recuperado = repository.findById(id);

        if(recuperado.isPresent()){
            System.out.println("Dados do autor");
            System.out.println(recuperado.get());
            Autor toUpdate = recuperado.get();
            toUpdate.setDataNascimento(LocalDate.of(1978, 1, 15));
            toUpdate.setNacionalidade("Norte-Americana");

            repository.save(toUpdate);

        }
    }


    @Test
    public void listarTodosTest() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        var count = repository.count();
        System.out.println("Total de autores: " + count);
    }

    @Test
    public void deleteByObjectTest(){
        UUID id = UUID.fromString("d25ef0a8-d0c3-46d9-b893-05551ac3829e");
        Optional<Autor> recuperado = repository.findById(id);
        if(recuperado.isPresent()){
            Autor toDelete = recuperado.get();
            repository.delete(toDelete);
            System.out.println("Autor excluído com sucesso " + toDelete.getNome());
        }

    }

    @Test
    public void deleteByIdTest(){
        UUID id = UUID.fromString("d2cdd579-4169-4eb1-9503-4e6f18071534");
        repository.deleteById(id);
    }

    @Test
    void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setNome("Marcelo Andrade");
        autor.setNacionalidade("Portuguesa");
        autor.setDataNascimento(LocalDate.of(1968, 4, 14));

        Livro livro = new Livro();
        livro.setIsbn("255-8");
        livro.setTitulo("As aventuras de PI");
        livro.setDataPublicacao(LocalDate.of(1999, 8, 20));
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setPreco(BigDecimal.valueOf(99.50));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("1989-12");
        livro2.setTitulo("Pai rico filho rico");
        livro2.setDataPublicacao(LocalDate.of(1997, 9, 22));
        livro2.setGenero(GeneroLivro.ROMANCE);
        livro2.setPreco(BigDecimal.valueOf(15.50));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
        //livroRepository.saveAll(autor.getLivros());

    }}
