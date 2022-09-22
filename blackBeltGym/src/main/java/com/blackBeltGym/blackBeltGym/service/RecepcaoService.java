package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.repository.ClienteRepository;
import com.blackBeltGym.blackBeltGym.repository.ModalidadeRepository;
import com.blackBeltGym.blackBeltGym.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class RecepcaoService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final ClienteRepository clienteRepository;
    private final ModalidadeRepository modalidadeRepository;
    private final ProfessorRepository professorRepository;


    public RecepcaoService(ClienteRepository clienteRepository, ModalidadeRepository modalidadeRepository, ProfessorRepository professorRepository) {
        this.clienteRepository = clienteRepository;
        this.modalidadeRepository = modalidadeRepository;
        this.professorRepository = professorRepository;
    }

    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Qual ação deseja executar?");
            System.out.println("1 - Visualizar");


            int action = scanner.nextInt();

            switch(action){
                case 1: visualizar();
                    break;

            }

        }
    }

    public void visualizar(){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(System.out::println);
    }


}

