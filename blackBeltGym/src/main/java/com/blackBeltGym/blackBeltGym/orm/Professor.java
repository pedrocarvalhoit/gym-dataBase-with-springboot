package com.blackBeltGym.blackBeltGym.orm;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private DadosPessoais dadosPessoais;
    private LocalDate dataContratacao;
    @ManyToMany(mappedBy = "professor")
    private List<Modalidade> modalidade;

    public Professor() {
    }

    public Professor(DadosPessoais dadosPessoais, LocalDate dataContratacao) {
        this.dadosPessoais = dadosPessoais;
        this.dataContratacao = dataContratacao;
        this.modalidade = modalidade;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public List<Modalidade> getModalidade() {
        return modalidade;
    }

    public void setModalidade(List<Modalidade> modalidade) {
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "dadosPessoais=" + dadosPessoais +
                '}';
    }
}
