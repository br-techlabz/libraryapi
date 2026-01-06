package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.GeneroLivro;
import br.techlabz.libraryapi.model.Livro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;


    @Test
    void salvarTest(){
        /**
        Autor autor = new Autor();
        autor.setNome("Willian Cevassi");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1982, 6, 15));
        autorRepository.save(autor);
        System.out.println("Autor Salvo: " + autor);
        **/

        Livro livro = new Livro();
        livro.setIsbn("15896-62");
        livro.setTitulo("A viagem 2");
        livro.setDataPublicacao(LocalDate.of(1989, 12, 25));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(59.90));
        Autor autor = autorRepository.findById(UUID.fromString("913a6860-8c3d-4b56-88ca-3f769019daed")).orElse(null);
        livro.setAutor(autor);

        repository.save(livro);
        System.out.println("Livro salvo: " + livro);

    }

    @Test
    void salvarCascadeTest(){

        Autor autor = new Autor();
        autor.setNome("Willian Cevassi");
        autor.setDataNascimento(LocalDate.of(1982,6,15));
        autor.setNacionalidade("Brasileira");
        System.out.printf("Autor Salvo: " + autor);

        Livro livro = new Livro();
        livro.setIsbn("15896-62");
        livro.setTitulo("A viagem 2");
        livro.setDataPublicacao(LocalDate.of(1989, 12, 25));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(59.90));
        livro.setAutor(autor);

        repository.save(livro);
        System.out.println("Livro salvo: " + livro);
    }

    @Test
    void recuperarPeloIdTest(){
        Optional<Livro> recuperado = repository.findById(UUID.fromString("77024fb3-82c0-4f26-9aa9-74c20173d1c6"));
        if(recuperado.isPresent()){
            System.out.println("Livro recuperado: " + recuperado);
        }
    }


    @Test
    void atualizarTest(){
        Autor autor = new Autor();
        autor.setNome("Renata Santos");
        autor.setDataNascimento(LocalDate.of(1979,5,7));
        autor.setNacionalidade("Brasileira");

        Optional<Livro> recuperado = repository.findById(UUID.fromString("77024fb3-82c0-4f26-9aa9-74c20173d1c6"));
        if(recuperado.isPresent()){
            Livro toUpdate = recuperado.get();
            toUpdate.setPreco(BigDecimal.valueOf(120.00));
            toUpdate.setAutor(autor);
            repository.save(toUpdate);
            System.out.println("Livro Atualizado " + toUpdate);
        }
    }

    @Test
    void deleteByIdTest(){
        repository.deleteById(UUID.fromString("365392f9-f48d-4a2a-9f3d-8f89257b9669"));
        System.out.println("Livro excluido!");
    }

    @Test
    void listAllTest(){
        List<Livro> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    void countTest(){
        var nreg = repository.count();
        System.out.println("Total de livros cadastrados: " + nreg);
    }

    @Test
    @Transactional //tecnica usada para carregar objetos do tipo Lazy dentro de uma transação
    void buscarLivroTest(){
        UUID id = UUID.fromString("f34c75c6-73b4-42fb-b84a-fb649973925d");
        Livro livro = repository.findById(id).orElse(null);
        System.out.println("Livro:");
        System.out.println(livro.getTitulo());
        System.out.println("Autor:");
        System.out.println(livro.getAutor().getNome());
    }

}