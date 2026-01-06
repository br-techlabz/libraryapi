package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.model.GeneroLivro;
import br.techlabz.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
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

}