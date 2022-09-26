package com.blackBeltGym.blackBeltGym.orm;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class DadosPessoais {

    private String cpf;
    private String firstName;
    private String lastName;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;

    public DadosPessoais() {
    }

    public DadosPessoais(String cpf, String fistName, String lastName, String telefone, String email, LocalDate dataDeNascimento) {
        this.cpf = cpf;
        this.firstName = fistName;
        this.lastName = lastName;
        this.telefone = telefone;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setFistName(String fistName) {
        this.firstName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFistName() {
        return firstName;
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
                ", fistName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                '}';
    }
}
