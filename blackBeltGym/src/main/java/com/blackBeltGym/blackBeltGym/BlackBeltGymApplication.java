package com.blackBeltGym.blackBeltGym;

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

	public BlackBeltGymApplication(RecepcaoService recepcaoService) {
		this.recepcaoService = recepcaoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlackBeltGymApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Quem é você?");
			System.out.println("2 - Recepção");

			Integer function = scanner.nextInt();

			switch (function){
				case 2: recepcaoService.iniciar(scanner);
			}
		}

	}
}
