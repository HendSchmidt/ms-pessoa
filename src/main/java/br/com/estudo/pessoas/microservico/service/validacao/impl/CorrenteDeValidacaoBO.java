package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.Map;
import java.util.Objects;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;
import br.com.estudo.pessoas.microservico.util.PessoaException;

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
	
	public void validar(PessoaDto dto,  PessoaRepository repository) {
		final Map<Boolean, String> pessoaValidada = valida(dto, repository);
		if(pessoaValidada.containsKey(true)) {
			throw new PessoaException(pessoaValidada.get(true));
		}

		if(Objects.nonNull(proximo))
			proximo.validar(dto, repository);
	}
	
	public abstract Map<Boolean, String> valida(PessoaDto dto,  PessoaRepository repository);
}
