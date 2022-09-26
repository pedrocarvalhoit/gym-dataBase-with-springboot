package com.blackBeltGym.blackBeltGym.orm;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_modalidades")
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String local;
    @ManyToMany(mappedBy = "modalidade", fetch = FetchType.EAGER)
    private List<Cliente> cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "modalidades_com_professores",
            joinColumns = {@JoinColumn(name = "fk_modalidade")  },
            inverseJoinColumns = {@JoinColumn(name = "fk_professor") }
    )
    private List<Professor> professor;

    public Modalidade() {
    }

    public Modalidade(String descricao, String local, List<Professor> professor) {
        this.descricao = descricao;
        this.local = local;
        this.cliente = cliente;
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Modalidade{" +
                "descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", professor=" + professor +
                '}';
    }
}
