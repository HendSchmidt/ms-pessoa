package br.com.estudo.pessoas.microservico.service.validacao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.validacao.ValidadorDeDadosDePessoa;

/**
 * @author hendrix.schmidt
 *
 */
@Service
public class ValidadorDeCpf implements ValidadorDeDadosDePessoa {
	private final Logger log = LogManager.getLogger();

	private CorrenteDeValidacaoDeCpf validacao;

	@Override
	public String validar(PessoaDto dto) {
		final String erro;
		log.info("Iniciando cadeia para validação da pessoa nome: {}, CPF: {} ", dto.getNmNome(), dto.getCdCpf());
		validacao = new ValidaCpfCaracteresEspeciais(
				new ValidaCpfPossui11Digitos(
						new ValidaCpfDigitosIguais(
								new ValidaCpfPrimeiroDigitoVerificador(
										new ValidaCpfSegundoDigitoVerificador(
												new ValidacaoCpfCompleta(null))))));

		erro = validacao.validar(dto);
		log.info("Finalizando cadeia para validação do CPF.");
		
		return erro;
	}

}
