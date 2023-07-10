package br.com.estudo.pessoas.microservico.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.service.PessoaService;
import br.com.estudo.pessoas.microservico.service.validacao.PessoaValidacao;

/**
 * @author hendrix.schmidt
 *
 */
@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {
	private final Logger log = LogManager.getLogger();
	
	@Autowired
	private PessoaValidacao validacao;
	
	@Override
	public PessoaDto listar() {
		return new PessoaDto( 1L, "Hendrix ", "1234596789", "123456789", "27/05/1992",
				"Masculino", "casado");
	}
	
	@Override
	public String cadastrar(PessoaDto dto) {
		log.info("Iniciando cadastro de pessoa.");
		validacao.validar(dto);
		
		return "Pessoa cadastrada com sucesso.";
	}
}
