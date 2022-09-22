package com.blackBeltGym.blackBeltGym.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private DadosPessoais dadosPessoais;
    @ManyToMany(mappedBy = "professor")
    private List<Modalidade> modalidade1;

    public Professor() {
    }
}
