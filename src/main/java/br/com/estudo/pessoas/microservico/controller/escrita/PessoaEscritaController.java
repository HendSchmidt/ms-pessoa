package br.com.estudo.pessoas.microservico.controller.escrita;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.PessoaService;

/**
 * @author hendrix.schmidt
 *
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaEscritaController {

	@Autowired
	private PessoaService service;
	
	@PostMapping
	public ResponseEntity<String> listar(@Valid @RequestBody PessoaDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
}
