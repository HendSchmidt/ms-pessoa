package br.com.estudo.pessoas.microservico.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.mapper.PessoaMapper;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;
import br.com.estudo.pessoas.microservico.service.PessoaService;
import br.com.estudo.pessoas.microservico.service.validacao.PessoaValidacao;
import br.com.estudo.pessoas.microservico.util.PessoaException;

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
	
	@Autowired
	private PessoaMapper mapper;
	
	@Autowired
	private PessoaRepository repository;

	@Override
	public List<PessoaDto> listar() {
		log.info("Recuperando doados de pessoas.");
		return mapper.mapearLsPessoaDto(repository.listar());
	}

	@Override
	public String cadastrar(final List<PessoaDto> lsDto) {
		log.info("Iniciando cadastro de pessoa(s).");
		lsDto.parallelStream().forEachOrdered(dto -> {
			validacao.validar(dto);
			
			repository.criar(mapper.mapear(dto));
		});

		return "Pessoa(s) cadastrada(s) com sucesso.";
	}

	@Override
	public PessoaDto recuperarPorId(final Long id) {
		return mapper.mapear(repository.recuperarPorId(id).orElseThrow(() -> new PessoaException("Pessoa não encontrada id: "+ id + ".")));
	}
}
