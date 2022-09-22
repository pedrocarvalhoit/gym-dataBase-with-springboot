package com.blackBeltGym.blackBeltGym.orm;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class DadosPessoais {

    private String cpf;
    private String fistName;
    private String lastName;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;

    public DadosPessoais() {
    }

    public DadosPessoais(String cpf, String fistName, String lastName, String telefone, String email, LocalDate dataDeNascimento) {
        this.cpf = cpf;
        this.fistName = fistName;
        this.lastName = lastName;
        this.telefone = telefone;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    @Override
    public String toString() {
        return "DadosPessoais{" +
                "cpf='" + cpf + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
