package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.Cliente;
import com.blackBeltGym.blackBeltGym.orm.DadosPessoais;
import com.blackBeltGym.blackBeltGym.orm.Modalidade;
import com.blackBeltGym.blackBeltGym.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RecepcaoServiceTest {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ClienteRepository clienteRepository;

    @Test
    public void matricula() {
        String cpf = "123123";

        String primeiroNome = "Pedro";

        String ultimoNome = "Carvalho";

        String telefone = "989898";

        String email = "sfgafgafg";

        String dataNascimento = "11/08/1992";

        String nivelAtividade = "fasfafa";

        LocalDate dataMatricula = LocalDate.now();

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf(cpf);
        dadosPessoais.setFistName(primeiroNome);
        dadosPessoais.setLastName(ultimoNome);
        dadosPessoais.setTelefone(telefone);
        dadosPessoais.setEmail(email);
        dadosPessoais.setDataDeNascimento(LocalDate.parse(dataNascimento, formatter));


        Modalidade musculacao = new Modalidade();
        musculacao.setDescricao("Musculacao");
        musculacao.setLocal("Sala terceiro andar");
        List<Modalidade> modalidades = new ArrayList<>();
        modalidades.add(musculacao);

        Cliente cliente = new Cliente(dadosPessoais, nivelAtividade, dataMatricula, modalidades);

        clienteRepository.save(cliente);
        System.out.println("Cliente matriculado");
    }


    @Test
    public void visualizar(){
        Iterable<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(System.out::println);
    }

}