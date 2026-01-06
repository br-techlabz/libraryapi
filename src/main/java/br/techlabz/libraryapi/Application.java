package br.techlabz.libraryapi;

import br.techlabz.libraryapi.model.Autor;
import br.techlabz.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//var context = SpringApplication.run(Application.class, args);
		SpringApplication.run(Application.class, args);
		//AutorRepository repository = context.getBean(AutorRepository.class);

		//exemploSalvarRegistro(repository);
	}

	/**
	public static void exemploSalvarRegistro(AutorRepository autorRepository) {
		Autor autor = new Autor();
		autor.setNome("Jose Saramago");
		autor.setNacionalidade("Portuguesa");
		autor.setDataNascimento(LocalDate.of(1965, 6, 16));
		var autorSalvo = autorRepository.save(autor);
		System.out.println("Autor Salvo: " + autorSalvo);
	}
	 */
}
