package br.com.estudo.pessoas.microservico.service.validacao;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

/**
 * @author hendrix.schmidt
 *
 */
public interface ValidadorDeDadosDePessoa {
	/**
	 * Contrato para separar a responsabilidade para cada tipo de validação de dados da pessoa.
	 * 
	 * @param dto
	 */
	String validar(PessoaDto dto);
}
