package br.com.estudo.pessoas.microservico.service.validacao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.validacao.ValidadorDeDadosDePessoa;
import br.com.estudo.pessoas.microservico.util.PessoaException;

/**
 * @author hendrix.schmidt
 *
 */
@Service
public class ValidadorDeNome implements ValidadorDeDadosDePessoa {
	private static final String REGEX_NAO_CONTEM_CARACTERES_ESPECIAIS = "[a-zA-Z ]+";
	private final Logger log = LogManager.getLogger();
	@Override
	public void validar(PessoaDto dto) {
		log.info("Validando Nome nome: {}, CPF: {} ", dto.getNmNome(), dto.getCdCpf());
		if (Boolean.FALSE.equals(dto.getNmNome().matches(REGEX_NAO_CONTEM_CARACTERES_ESPECIAIS))) {
			throw new PessoaException("Nome não pode conter catacteres especiais.");
		}
	}

}
