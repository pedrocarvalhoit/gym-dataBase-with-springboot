package com.blackBeltGym.blackBeltGym.orm;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private DadosPessoais dadosPessoais;
    private String nivelDeAtividade;
    private LocalDate dataMatricula;

    @Fetch(FetchMode.SELECT)
    @ManyToMany
    //Cria a tabela que irá conter os dois itens relacionados
    @JoinTable(
            name = "clientes_com_modalidade",
            joinColumns = {@JoinColumn(name = "fk_cliente")},
            inverseJoinColumns = {@JoinColumn(name = "fk_modalidade")}
    )
    private List<Modalidade> modalidade;

    public Cliente() {
    }

    public Cliente(DadosPessoais dadosPessoais, String nivelDeAtividade, LocalDate dataMatricula, List<Modalidade> modalidade) {
        this.dadosPessoais = dadosPessoais;
        this.nivelDeAtividade = nivelDeAtividade;
        this.dataMatricula = dataMatricula;
        this.modalidade = modalidade;
    }

    public Integer getId() {
        return id;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public String getNivelDeAtividade() {
        return nivelDeAtividade;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public List<Modalidade> getModalidade() {
        return modalidade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dadosPessoais=" + dadosPessoais +
                ", nivelDeAtividade='" + nivelDeAtividade + '\'' +
                '}';
    }
}
