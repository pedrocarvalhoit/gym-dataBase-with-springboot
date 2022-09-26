package com.blackBeltGym.blackBeltGym;

import com.blackBeltGym.blackBeltGym.service.GerenteService;
import com.blackBeltGym.blackBeltGym.service.ProprietarioDinamico;
import com.blackBeltGym.blackBeltGym.service.RecepcaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class BlackBeltGymApplication implements CommandLineRunner {

	private Boolean system = true;
	private final RecepcaoService recepcaoService;
	private final GerenteService gerenteService;
	private final ProprietarioDinamico proprietarioDinamico;

	public BlackBeltGymApplication(RecepcaoService recepcaoService, GerenteService gerenteService,ProprietarioDinamico proprietarioDinamico ) {
		this.recepcaoService = recepcaoService;
		this.gerenteService = gerenteService;
		this.proprietarioDinamico = proprietarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlackBeltGymApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);


		while(system){
			System.out.println("Quem é você?");
			System.out.println("1 - Gerente");
			System.out.println("2 - Recepção");
			System.out.println("3 - Proprietário");

			Integer function = scanner.nextInt();

			switch (function){
				case 1: gerenteService.iniciar(scanner);
				case 2: recepcaoService.iniciar(scanner);
				case 3: proprietarioDinamico.iniciar(scanner);
			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
		}

	}
}
