package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.Map;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * @author hendrix.schmidt
 *
 */
public abstract class CorrenteDeValidacaoBO {
	
	protected CorrenteDeValidacaoBO proximo;

	public CorrenteDeValidacaoBO(CorrenteDeValidacaoBO proximo) {
		super();
		this.proximo = proximo;
	}
	
	public String validar(PessoaDto dto,  PessoaRepository repository) {
		final Map<Boolean, String> pessoaValidada = valida(dto, repository);
		if(pessoaValidada.containsKey(true)) {
			return pessoaValidada.get(true);
		}
		
		return proximo.validar(dto, repository);
	}
	
	public abstract Map<Boolean, String> valida(PessoaDto dto,  PessoaRepository repository);
}
