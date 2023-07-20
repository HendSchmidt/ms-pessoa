package br.com.estudo.pessoas.microservico.controller.escrita;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> cadastrar(@Valid @RequestBody PessoaDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
	}
	
	@PutMapping
	public ResponseEntity<String> atualizar( @Valid @RequestBody PessoaDto dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(dto));
	}
	
	@DeleteMapping("/{cdCpf}")
	public ResponseEntity<Object> deletar(@NotBlank @PathVariable String cdCpf) {
		return ResponseEntity.status(HttpStatus.OK).body(service.deletar(cdCpf));
	}
}
