package br.com.estudo.pessoas.microservico.service.validacao;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

public interface PessoaValidacao {
	void validar(PessoaDto dto);
}
