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
public class ValidaCpfPossui11Digitos extends CorrenteDeValidacaoDeCpf {
	private final Logger log = LogManager.getLogger();
	
	public ValidaCpfPossui11Digitos(CorrenteDeValidacaoDeCpf proximo) {
		super(proximo);
	}

	@Override
	public Map<Boolean, String> valida(PessoaDto dto) {
		log.info("[2] Validando se o cpf possui 11 digitos.");
		Map<Boolean, String> cpfValidado = new HashMap<>();
		cpfValidado.put(dto.getCdCpf().length() != 11, "CPF informado não poder ter mais ou menos que 11 digitos. CPF [" + dto.getCdCpf() + "]" );

		return cpfValidado;
	}
}
