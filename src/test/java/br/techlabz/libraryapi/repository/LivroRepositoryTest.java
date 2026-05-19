package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.GeneroLivro;
import br.techlabz.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    LivroRepository repo;

    @Autowired
    AutorRepository repoAutor;

    @Test
    public void salvarTest(){
        UUID idAutor = UUID.fromString("555aa69b-57c8-4b57-a590-397e4f12616c");
        Autor autor = repoAutor.findById(idAutor).get();
        Livro l1 = new Livro(null,
                "123456",
                "Titulo do livro 1",
                LocalDate.of(2024,1,15),
                89.9,
                GeneroLivro.ROMAMCE,
                autor);

        Livro salvo = repo.save(l1);
        System.out.println("Livro salvo: " + salvo);
    }
}