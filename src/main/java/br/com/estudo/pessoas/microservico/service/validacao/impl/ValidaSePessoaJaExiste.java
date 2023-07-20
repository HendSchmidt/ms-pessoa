package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

public class ValidaSePessoaJaExiste implements ValidacaoDeNegocio {
	private final Logger log = LogManager.getLogger();
	
	@Override
	public Map<Boolean, String> validar(PessoaDto dto,  PessoaRepository repository) {
		log.info("[1] Validando se pessoa ja existe na base de dados.");
		Map<Boolean, String> pessoaValidada = new HashMap<>();
		
		pessoaValidada.put(repository.verificaSeExistePorCdCpf(dto.getCdCpf()), "CPF informado ja pertence a uma pessoa cadastrada.");
		
		return pessoaValidada;
	}

}
