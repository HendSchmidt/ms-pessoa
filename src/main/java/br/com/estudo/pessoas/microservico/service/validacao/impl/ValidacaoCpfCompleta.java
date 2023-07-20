package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

public class ValidacaoCpfCompleta extends CorrenteDeValidacaoDeCpf {
	private final Logger log = LogManager.getLogger();

	public ValidacaoCpfCompleta(CorrenteDeValidacaoDeCpf proximo) {
		super(null);
	}

	@Override
	public Map<Boolean, String> valida(PessoaDto dto) {
		log.info("[6] Cpf validado com sucesso.");
		Map<Boolean, String> cpfValidado = new HashMap<>();
		cpfValidado.put(Boolean.FALSE, "");
		return cpfValidado;
	}

}
