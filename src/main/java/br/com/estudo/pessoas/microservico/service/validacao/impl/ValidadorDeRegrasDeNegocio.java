package br.com.estudo.pessoas.microservico.service.validacao.impl;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * @author hendrix.schmidt
 *
 */
public interface ValidadorDeRegrasDeNegocio {

	/**
	 * Contrato para separar a responsabilidade para cada tipo de validação de regras relacionadas ao negocio.
	 * 
	 * @param dto
	 */
	void validar(PessoaDto dto,  PessoaRepository repository);
}
