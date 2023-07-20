package br.com.estudo.pessoas.microservico.service;

import java.util.List;

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
	List<PessoaDto> listar();
	
	/**
	 * Recupera a pessoa através do id fornecido.
	 * 
	 * @param id
	 * @return
	 */
	PessoaDto recuperarPorId(final Long id);

	/**
	 * Cadastra uma pessoa no sistema baseado no objeto pessoaDto e tambem em validações de regra de negocio.
	 * 
	 * @param dto
	 * @return
	 */
	String cadastrar(final PessoaDto dto);

}
