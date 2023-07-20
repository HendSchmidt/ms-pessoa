package br.com.estudo.pessoas.microservico.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
	 * Recupera a pessoa através do cpf fornecido.
	 * 
	 * @param id
	 * @return
	 */
	PessoaDto recuperarPorcdCpf(final String cdCpf);

	/**
	 * Cadastra uma pessoa no sistema baseado no objeto pessoaDto e tambem em validações de regra de negocio.
	 * 
	 * @param dto
	 * @return
	 */
	String cadastrar(final PessoaDto dto);

	/**
	 * Atualiza uma pessoa de acordo com o cpf fornecido.
	 * 
	 * @param cdCpf
	 * @param dto
	 * @return
	 */
	String atualizar(@Valid PessoaDto dto);
	
	/**
	 * Deleta uma pessoa dado o cpf da mesma.
	 * 
	 * @param cdCpf
	 * @return
	 */
	Object deletar(@NotBlank String cdCpf);

}
