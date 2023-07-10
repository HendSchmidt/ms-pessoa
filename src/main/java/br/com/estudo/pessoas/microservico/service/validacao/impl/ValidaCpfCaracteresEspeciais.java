package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

/**
 * @author hendrix.schmidt
 *
 */
public class ValidaCpfCaracteresEspeciais  extends ValidacaoCpf {
	private final Logger log = LogManager.getLogger();
	
	public ValidaCpfCaracteresEspeciais(ValidacaoCpf proximo) {
		super(proximo);
	}

	@Override
	public Map<Boolean, String> validaCpf(PessoaDto dto) {
		log.info("[1] Validando caracteres especiais.");
		Map<Boolean, String> cpfValidado = new HashMap<>();
		final String REGEX_VALIDACAO_CARACTERES_ESPECIAIS_CPF = "[^0-9]";
		cpfValidado.put(dto.getCdCpf().contains(REGEX_VALIDACAO_CARACTERES_ESPECIAIS_CPF), "CPF informado não deve conter catacteres especiais.");
		
		return cpfValidado;
	}
}
