package br.techlabz.libraryapi.repository;

import br.techlabz.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository repo;

    @Test
    public void salvarTest(){
        Autor a1 = new Autor(null,"Willian", LocalDate.of(1975, 8, 18),"Brasileira");
        Autor autorSalvo = repo.save(a1);
        System.out.println("Autor salvo " + autorSalvo);
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("65a903ab-a3ec-4ee6-92b3-0ff939c727d7");
        Optional<Autor> possivelAutor = repo.findById(id);
        if(possivelAutor.isPresent()){
            Autor encontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.printf(possivelAutor.toString());
            encontrado.setNome("José Saramago de Oliveira");
            encontrado.setDataNascimento(LocalDate.of(1957, 8, 12));
            repo.save(encontrado);
        }
    }

    @Test
    public void listarTest(){
        List<Autor> lista = repo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Total de autores: " + repo.count());
    }

    @Test
    public void deletarPorIdTest(){
        var id = UUID.fromString("65a903ab-a3ec-4ee6-92b3-0ff939c727d7");
        repo.deleteById(id);
        System.out.println("Autor excluído");
    }

    @Test
    public void deletarPeloObjeto(){
        var id = UUID.fromString("7beaf2f0-0634-4ce6-b4cc-68345fc49da7");
        Optional<Autor> possivelAutor = repo.findById(id);
        if(possivelAutor.isPresent()) {
            Autor toDelete = possivelAutor.get();
            repo.delete(toDelete);
            System.out.println("Autor excluído");
        }

    }}
