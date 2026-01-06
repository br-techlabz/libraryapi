package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository repository;

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
}
