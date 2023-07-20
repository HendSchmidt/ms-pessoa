package br.com.estudo.pessoas.microservico.service.impl;

import static java.time.LocalDateTime.now;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.domain.jdbc.pessoa.Pessoa;
import br.com.estudo.pessoas.microservico.mapper.PessoaMapper;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;
import br.com.estudo.pessoas.microservico.service.PessoaService;
import br.com.estudo.pessoas.microservico.service.validacao.impl.PessoaValidacao;
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
	public String cadastrar(final PessoaDto dto) {
		log.info("Iniciando cadastro de pessoa.");

		validacao.validarParaCriacao(dto, repository);
		repository.criar(mapper.mapear(dto));

		return "Pessoa cadastrada com sucesso.";
	}

	@Override
	public PessoaDto recuperarPorcdCpf(final String cdCpf) {
		return mapper.mapear(repository.recuperarPorcdCpf(cdCpf).orElseThrow(() -> new PessoaException("Pessoa não encontrada CPF: "+ cdCpf + ".")));
	}

	@Override
	public String atualizar(PessoaDto dto) {
		log.info("Iniciando atuzalização de pessoa.");
		
		validacao.validarParaAtualizacao(dto, repository);
		repository.atualizar(preparaParaAtualizar(dto));
		
		return "Pessoa atualizada com sucesso.";
	}

	@Override
	public Object deletar(String cdCpf) {
		log.info("Iniciando exclusão de pessoa(s).");
		
		validacao.validarParaExclusao(preparaParaExcluir(cdCpf), repository);
		repository.excluirPorCpf(cdCpf);
		
		return "Pessoa excluida com sucesso.";
	}

	private PessoaDto preparaParaExcluir(String cdCpf) {
		PessoaDto dto = new PessoaDto();
		dto.setCdCpf(cdCpf);
		
		return dto;
	}
	
	private Pessoa preparaParaAtualizar(PessoaDto dto) {
		final Pessoa entidade = mapper.mapear(dto);
		entidade.setInAtivo(true);
		entidade.setDtAlteracao(now());
		return entidade;
	}
}
