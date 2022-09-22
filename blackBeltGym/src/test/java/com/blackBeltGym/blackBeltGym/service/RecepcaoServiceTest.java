package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecepcaoServiceTest {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ClienteRepository clienteRepository;
    @Test
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

    @Test
    public void visualizar(){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(System.out::println);
    }

}