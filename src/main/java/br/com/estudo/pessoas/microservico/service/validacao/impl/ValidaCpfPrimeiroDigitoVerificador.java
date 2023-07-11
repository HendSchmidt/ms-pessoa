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
public class ValidaCpfPrimeiroDigitoVerificador extends ValidacaoCpf {
	private final Logger log = LogManager.getLogger();
	
	public ValidaCpfPrimeiroDigitoVerificador(ValidacaoCpf proximo) {
		super(proximo);
	}

	@Override
	public Map<Boolean, String> validaCpf(PessoaDto dto) {
		
		log.info("[4] Validando primeiro digito verificador.");
		Map<Boolean, String> cpfValidado = new HashMap<>();
		cpfValidado.put(Boolean.FALSE.equals(verificaDigito(dto.getCdCpf(), 10, 9)), "CPF informado possui primeiro digito verificador invalido. CPF [" + dto.getCdCpf() + "]");

		return cpfValidado;
	}

}
