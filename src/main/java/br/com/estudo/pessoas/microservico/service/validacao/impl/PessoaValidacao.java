package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.validacao.ValidadorDePessoa;

/**
 * Responsavel por orquestrar todas as validações de pessoa.
 * 
 * @author hendrix.schmidt
 *
 */
@Service
public class PessoaValidacao  {
	
	@Autowired
	private List<ValidadorDePessoa> lsPessoaValidacao;

	public void validar(PessoaDto dto) {
		lsPessoaValidacao.parallelStream().forEachOrdered(v -> v.validar(dto));
	}

}
