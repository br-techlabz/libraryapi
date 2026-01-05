package br.techlabz.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public")
@Getter //gera os metodos getters (Lombok)
@Setter // gera os metodos setters (Lombok)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column (length = 50, nullable = false)
    private String nacionalidade;


    @Deprecated
    public Autor(){

    }

    public Autor(String nome, LocalDate dataNascimento, String nacionalidade){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }
}
