package br.com.estudo.pessoas.microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.estudo.pessoas.microservico")
public class MicroServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicoApplication.class, args);
	}

}
