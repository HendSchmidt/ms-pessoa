package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.Map;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * @author hendrix.schmidt
 *
 * Responsavel por criar um contrato entre todas validações de regras de negocio.
 *
 */
public interface ValidacaoDeNegocio {
	
	public Map<Boolean, String> validar(PessoaDto dto,  PessoaRepository repository);
}
