package com.blackBeltGym.blackBeltGym.service;

import com.blackBeltGym.blackBeltGym.orm.DadosPessoais;
import com.blackBeltGym.blackBeltGym.orm.Modalidade;
import com.blackBeltGym.blackBeltGym.orm.Professor;
import com.blackBeltGym.blackBeltGym.repository.ModalidadeRepository;
import com.blackBeltGym.blackBeltGym.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class GerenteService {

    /**Não consigo criar modalidade usando professor ja existente no banco */

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final ModalidadeRepository modalidadeRepository;
    private final ProfessorRepository professorRepository;


    public GerenteService(ModalidadeRepository modalidadeRepository, ProfessorRepository professorRepository) {
        this.modalidadeRepository = modalidadeRepository;
        this.professorRepository = professorRepository;
    }

    public void iniciar(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação deseja executar?");
            System.out.println("0 - Voltar");
            System.out.println("1 - Cadastrar professor");//ok, Professor nao cadastra modalidade
            System.out.println("2 - Deletar professor");//ok
            System.out.println("3 - Buscar professor pelo último nome");//ok
            System.out.println("4 - Cadastro modalidade");
            System.out.println("x - Cadastro professor na modalidade");
            System.out.println("x - Listar modalidades e professores");


            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    cadastraProfessor(scanner);
                    break;
                case 2:
                    deletarProfessor(scanner);
                    break;
                case 3:
                    buscarProfessorPorUltimoNome(scanner);
                    break;
                case 4:
                    cadastroModalidade(scanner);
                    break;
                default:
                    system = false;
                    break;

            }

        }
    }

    private void cadastroModalidade(Scanner scanner) {
        System.out.println("Digite a descrição da modalidade:");
        String descricao = scanner.next();

        System.out.println("Digite o local desta modalidade");
        String local = scanner.next();

        System.out.println("Digite o último nome do professor desta modalidade");
        String professorModalidade = scanner.next();

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf("123132");
        dadosPessoais.setFistName("Luisa");
        dadosPessoais.setLastName("Lage");
        dadosPessoais.setTelefone("+2256565");
        dadosPessoais.setEmail("lllll@ggg.com");
        dadosPessoais.setDataDeNascimento(LocalDate.parse("22/12/1992", formatter));

        Professor professor = new Professor(dadosPessoais, LocalDate.now());
        List<Professor> professores = new ArrayList<>();
        professores.add(professor);

        Modalidade modalidade = new Modalidade(descricao, local,professores);
        modalidadeRepository.save(modalidade);
    }

    private void cadastraProfessor(Scanner scanner) {
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

        LocalDate dataContratacao = LocalDate.now();

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf(cpf);
        dadosPessoais.setFistName(primeiroNome);
        dadosPessoais.setLastName(ultimoNome);
        dadosPessoais.setTelefone(telefone);
        dadosPessoais.setEmail(email);
        dadosPessoais.setDataDeNascimento(LocalDate.parse(dataNascimento, formatter));

        Professor professor = new Professor(dadosPessoais, dataContratacao);
        professorRepository.save(professor);
        System.out.println("Professor cadastrado com sucesso");
    }

    private void deletarProfessor(Scanner scanner) {
        System.out.println("Digite o id do professor a ser deletado");
        Integer id = scanner.nextInt();
        professorRepository.deleteById(id);
        System.out.println("Deletado com sucesso");
    }

    private void buscarProfessorPorUltimoNome(Scanner scanner) {
        System.out.println("Diginte o último nome do professor");
        String lastName = scanner.next();
        Iterable<Professor> professores = professorRepository.findByDadosPessoaisLastName(lastName);
        professores.forEach(System.out::println);
    }


}

