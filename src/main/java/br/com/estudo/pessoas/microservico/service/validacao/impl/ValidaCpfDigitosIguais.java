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
public class ValidaCpfDigitosIguais extends CorrenteDeValidacaoDeCpf {
	private final Logger log = LogManager.getLogger();
	
	public ValidaCpfDigitosIguais(CorrenteDeValidacaoDeCpf proximo) {
		super(proximo);
	}

	@Override
	public Map<Boolean, String> valida(PessoaDto dto) {
		log.info("[3] Validando se o CPF possui todos digitos iguais.");
		final String REGEX_VALIDACAO_DIGITOS_IGUAIS_CPF = "(\\d)\\1{10}";
		Map<Boolean, String> cpfValidado = new HashMap<>();
		
		cpfValidado.put(dto.getCdCpf().matches(REGEX_VALIDACAO_DIGITOS_IGUAIS_CPF), "CPF informado não deve possuir todo digitos iguais.");
		
		return cpfValidado;
	}
}
