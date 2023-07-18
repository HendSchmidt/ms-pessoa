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
public class ValidaCpfSegundoDigitoVerificador extends CorrenteDeValidacaoDeCpf {
	private final Logger log = LogManager.getLogger();
	
	public ValidaCpfSegundoDigitoVerificador(CorrenteDeValidacaoDeCpf proximo) {
		super(proximo);
	}

	@Override
	public Map<Boolean, String> valida(PessoaDto dto) {
		log.info("[5] Validando segundo digito verificador.");
		Map<Boolean, String> cpfValidado = new HashMap<>();
		cpfValidado.put(Boolean.FALSE.equals(verificaDigito(dto.getCdCpf(), 11, 10)), "Cpf informado possui segundo digito verificador invalido.");

		return cpfValidado;
	}
}
