package br.com.estudo.pessoas.microservico.service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

/**
 * @author hendrix.schmidt
 *
 */
public interface PessoaService {

	/**
	 * Retorna uma lista de todas pessoa cadastradas no sistema.
	 * 
	 * @return
	 */
	PessoaDto listar();

	/**
	 * Cadastra uma pessoa no sistema baseado no objeto pessoaDto e tambem em validações de regra de negocio.
	 * 
	 * @param dto
	 * @return
	 */
	String cadastrar(PessoaDto dto);

}
