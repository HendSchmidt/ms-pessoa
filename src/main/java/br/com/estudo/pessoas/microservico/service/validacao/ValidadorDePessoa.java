package br.com.estudo.pessoas.microservico.service.validacao;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

/**
 * @author hendrix.schmidt
 *
 */
public interface ValidadorDePessoa {
	/**
	 * Contrato para separar a responsabilidade para cada tipo de validação de pessoa.
	 * 
	 * @param dto
	 */
	void validar(PessoaDto dto);
}
