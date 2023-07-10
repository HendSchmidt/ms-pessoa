package br.com.estudo.pessoas.microservico.service.validacao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.validacao.PessoaValidacao;

/**
 * @author hendrix.schmidt
 *
 */
@Service
public class PessoaValidacaoImpl implements PessoaValidacao {
	private final Logger log = LogManager.getLogger();

	private ValidacaoCpf validacaoCpf;

	@Override
	public void validar(PessoaDto dto) {
		log.info("Iniciando cadeia para validação do CPF.");
		validacaoCpf = new ValidaCpfCaracteresEspeciais(
				new ValidaCpfPossui11Digitos(
						new ValidaCpfDigitosIguais(
								new ValidaCpfPrimeiroDigitoVerificador(
										new ValidaCpfSegundoDigitoVerificador(
												new ValidacaoCpfCompleta(null))))));

		validacaoCpf.validar(dto);
		log.info("Finalizando cadeia para validação do CPF.");
	}

}
