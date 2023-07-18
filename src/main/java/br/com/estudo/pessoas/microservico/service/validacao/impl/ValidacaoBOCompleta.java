package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

public class ValidacaoBOCompleta extends CorrenteDeValidacaoBO {
	private final Logger log = LogManager.getLogger();

	public ValidacaoBOCompleta(CorrenteDeValidacaoDeCpf proximo) {
		super(null);
	}

	@Override
	public Map<Boolean, String> valida(PessoaDto dto,  PessoaRepository repository) {
		log.info("Validação de Objeto de negocio completa.");
		Map<Boolean, String> validacaoBo = new HashMap<>();
		validacaoBo.put(Boolean.TRUE, "");
		return validacaoBo;
	}

}
