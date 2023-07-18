package br.com.estudo.pessoas.microservico.service.validacao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * A partir daqui serão implementadas as regras de negocio.
 * 
 * @author hendrix.schmidt
 *
 */
@Service
public class ValidadorBO implements ValidadorDeRegrasDeNegocio {
	private final Logger log = LogManager.getLogger();
	
	private CorrenteDeValidacaoBO validacao;
	
	@Override
	public String validar(PessoaDto dto,  PessoaRepository repository) {
		final String erro;
		log.info("Iniciando cadeia de validação para regras de negocio ");
		validacao = new ValidaSePessoaJaExiste(null);
		
		erro = validacao.validar(dto, repository);
		log.info("Finalizando cadeia de validação para regras de negocio.");
		
		return erro;
	}

}
