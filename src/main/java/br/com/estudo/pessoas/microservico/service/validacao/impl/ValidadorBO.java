package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;
import br.com.estudo.pessoas.microservico.util.PessoaException;

/**
 * A partir daqui serão implementadas as regras de negocio.
 * 
 * @author hendrix.schmidt
 *
 */
@Service
public class ValidadorBO {
	private final Logger log = LogManager.getLogger();
	
	private ValidacaoDeNegocio validacao;
	
	public void validarParaCriacao(PessoaDto dto,  PessoaRepository repository) {
		log.info("Iniciando cadeia de validação para criar pessoa");
		validacao = new ValidaSePessoaJaExiste();
		
		final Map<Boolean, String> pessoaValida = validacao.validar(dto, repository);
		
		if (Boolean.TRUE.equals(pessoaValida.entrySet().stream().map(entry -> entry.getKey()).findFirst().get())) {
			throw new PessoaException(pessoaValida.get(true));
		}
		log.info("Finalizando cadeia de validação para regras de negocio.");
	}

	public void validarParaAtualizacao(PessoaDto dto, PessoaRepository repository) {
		log.info("Iniciando cadeia de validação para atualizar pessoa");
		validacao = new ValidaSePessoaJaExiste();
		
		final Map<Boolean, String> pessoaValida = validacao.validar(dto, repository);
		if (Boolean.FALSE.equals(pessoaValida.entrySet().stream().map(entry -> entry.getKey()).findFirst().get())) {
			throw new PessoaException("Para atualizar uma pessoa ela precisa existir.");
		}
		
		log.info("Finalizando cadeia de validação para regras de negocio.");
	}

	public void validarParaExclusao(PessoaDto dto, PessoaRepository repository) {
		log.info("Iniciando cadeia de validação para excluir pessoa");
		validacao = new ValidaSePessoaJaExiste();
		
		final Map<Boolean, String> pessoaValida = validacao.validar(dto, repository);
		if (Boolean.FALSE.equals(pessoaValida.entrySet().stream().map(entry -> entry.getKey()).findFirst().get())) {
			throw new PessoaException("Para Excluir uma pessoa ela precisa existir.");
		}
		
		log.info("Finalizando cadeia de validação para regras de negocio.");
		
	}
}
