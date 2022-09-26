package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.*;
import com.blackBeltGym.blackBeltGym.repository.ClienteRepository;
import com.blackBeltGym.blackBeltGym.repository.ModalidadeRepository;
import com.blackBeltGym.blackBeltGym.repository.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class RecepcaoService {

    /**Não consigo ordenar por DadosPessoais.nome */

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
            System.out.println("0 - Sair");//ok
            System.out.println("1 - Matricular cliente");//ok
            System.out.println("2 - Visualizar Clientes");//ok
            System.out.println("3 - Deletar Cliente");//ok
            System.out.println("4 - Buscar Cliente pelo nome");//ok
            System.out.println("5 - Visualizar Professores");//ok
            System.out.println("6 - Listar clientes por modalidades");//ok
            System.out.println("7 - Projeção id com nível de atividade");


            int action = scanner.nextInt();

            switch(action){
                case 1: matriculaCliente(scanner);
                    break;
                case 2: visualizarClientes(scanner);
                    break;
                case 3: deletarCliente(scanner);
                    break;
                case 4: buscaClientePorNome(scanner);
                    break;
                case 5: visualizarProfessores(scanner);
                    break;
                case 6: buscaClientesComModalidade(scanner);
                    break;
                case 7: buscarIdComModalidade();
                    break;
                    default:
                    system = false;
                    break;

            }

        }
    }

    private void buscaClientePorNome(Scanner scanner) {
        System.out.println("Digite o primeiro nome do cliente");
        String name = scanner.next();
        List<Cliente> listaClientes = clienteRepository.findByDadosPessoaisFirstName(name);
        listaClientes.forEach(System.out::println);
    }

    private void buscaClientesComModalidade(Scanner scanner){
        System.out.println("Digite a descrição da modalidade");
        String descricao = scanner.next();
        List<Cliente> listaClientes = clienteRepository.findByModalidadeDescricao(descricao);
        listaClientes.forEach((c)-> System.out.println(c.getDadosPessoais().getFistName()));
    }

    private void matriculaCliente(Scanner scanner) {
        System.out.println("Digite o cpf");
        String cpf = scanner.next();

        System.out.println("Digite o primeiro nome");
        String primeiroNome = scanner.next();

        System.out.println("Digite o ultimo nome");
        String ultimoNome = scanner.next();

        System.out.println("Digite o telefone");
        String telefone = scanner.next();

        System.out.println("Digite o email");
        String email = scanner.next();

        System.out.println("Digite a data de nascimento");
        String dataNascimento = scanner.next();

        System.out.println("Digite o nível de atividade: Iniciante, Intermediário ou Avançado");
        String nivelAtividade = scanner.next();

        LocalDate dataMatricula = LocalDate.now();

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf(cpf);
        dadosPessoais.setFistName(primeiroNome);
        dadosPessoais.setLastName(ultimoNome);
        dadosPessoais.setTelefone(telefone);
        dadosPessoais.setEmail(email);
        dadosPessoais.setDataDeNascimento(LocalDate.parse(dataNascimento, formatter));


        Modalidade modalidade = new Modalidade();
        modalidade.setDescricao("Musculacao");
        modalidade.setLocal("Sala terceiro andar");
        List<Modalidade> modalidades = new ArrayList<>();
        modalidades.add(modalidade);

        Cliente cliente = new Cliente(dadosPessoais, nivelAtividade, dataMatricula, modalidades);
         clienteRepository.save(cliente);
        System.out.println("Cliente matriculado");
    }

    private void visualizarClientes(Scanner scanner){
        System.out.println("Qual pagina você deseja visualizar");
        Integer page = scanner.nextInt();

        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.ASC, "dataMatricula");
        Page<Cliente> clientes = clienteRepository.findAll(pageable);

        System.out.println(clientes);
        //Número da página atual
        System.out.println("Pagina atual " + clientes.getNumber());
        //Total de elementos
        System.out.println("Total de elementos " + clientes.getTotalElements());
        clientes.forEach(System.out::println);
    }

    public void visualizarProfessores(Scanner scanner){
        System.out.println("Qual página você deseja visualizar");
        Integer page = scanner.nextInt();
        // Ordenação
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "dataContratacao"));
        Page<Professor> professores = professorRepository.findAll(pageable);

        System.out.println(professores);
        System.out.println("Página atual: " + professores.getNumber());
        System.out.println("Total de elementos " + professores.getTotalElements());
        professores.forEach(System.out::println);
    }

    private void deletarCliente(Scanner scanner){
        System.out.println("Digite o id do cliente a ser deletado");
        Integer id = scanner.nextInt() ;
        clienteRepository.deleteById(id);
        System.out.println("Deletado");
    }

    private void buscarIdComModalidade(){
        List<ClienteProjecao> lista = clienteRepository.findClienteIdComModalidade();
        lista.forEach(c-> System.out.println("Cpf: " + c.getCpf() + "Id: " + c.getId() + " Nível de atividade: " + c.getNivel_De_Atividade()));
    }







}

