package br.com.estudo.pessoas.microservico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.estudo.pessoas.microservico.controller",
		"br.com.estudo.pessoas.microservico.controller.escrita",
		"br.com.estudo.pessoas.microservico.controller.leitura", "br.com.estudo.pessoas.microservico.service.impl",
		"br.com.estudo.pessoas.microservico.service.validacao.impl", "br.com.estudo.pessoas.microservico.mapper", "br.com.estudo.pessoas.microservico.repository.impl" })
public class MicroServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicoApplication.class, args);
	}

}
