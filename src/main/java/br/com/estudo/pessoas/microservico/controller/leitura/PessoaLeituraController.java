package br.com.estudo.pessoas.microservico.controller.leitura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaLeituraController {
	
	@Autowired
	 private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}
	
	@GetMapping("/{cdCpf}")
	public ResponseEntity<PessoaDto> recuperarPorId(@PathVariable("cdCpf") final String cdCpf) {
		return ResponseEntity.status(HttpStatus.OK).body(service.recuperarPorcdCpf(cdCpf));
	}
}
