package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.repository.ClienteRepository;
import com.blackBeltGym.blackBeltGym.repository.ModalidadeRepository;
import com.blackBeltGym.blackBeltGym.repository.ProfessorRepository;
import com.blackBeltGym.blackBeltGym.specification.SpecificationCliente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ProprietarioDinamico {

    private final ClienteRepository clienteRepository;
    private final ProfessorRepository professorRepository;
    private final ModalidadeRepository modalidadeRepository;

    public ProprietarioDinamico(ClienteRepository clienteRepository, ProfessorRepository professorRepository, ModalidadeRepository modalidadeRepository) {
        this.clienteRepository = clienteRepository;
        this.professorRepository = professorRepository;
        this.modalidadeRepository = modalidadeRepository;
    }

    public void iniciar(Scanner scanner){
        System.out.println("Digite o nivel de atividade");
        String nivel = scanner.next();

        List<Cliente> clientes = clienteRepository.findAll(Specification.where(SpecificationCliente.nivelDeAtividade(nivel)));
        clientes.forEach(System.out::println);
    }


}
