package br.com.estudo.pessoas.microservico.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.domain.jdbc.pessoa.Pessoa;

@Component
public class PessoaMapper {
	private final Logger log = LogManager.getLogger();
	
	public List<PessoaDto> mapearLsPessoaDto(List<Pessoa> lsPessoa){
		return lsPessoa.parallelStream().map(this::mapear).collect(Collectors.toList());
	}

	public Pessoa mapear(PessoaDto dto) {
		log.info("Mapeando pessoa {}, CPF {}.", dto.getNmNome(), dto.getCdCpf());
		Pessoa entidade = new Pessoa(dto.getNmNome(), dto.getCdCpf(), dto.getCdRg(), dto.getDtNascimento(),
				dto.getNmSexo(), dto.getNmEstadoCivil());

		return entidade;
	}

	public PessoaDto mapear(Pessoa entidade) {
		log.info("Mapeando pessoa {}, CPF {}.", entidade.getNmNome(), entidade.getCdCpf());
		PessoaDto dto = new PessoaDto(entidade.getIdPessoa(), entidade.getNmNome(), entidade.getCdCpf(),
				entidade.getCdRg(), entidade.getDtNascimento(), entidade.getNmSexo(), entidade.getNmEstadoCivil());
		dto.setInAtivo(entidade.getInAtivo());
		dto.setDtCriacao(entidade.getDtCriacao());
		dto.setDtAlteracao(entidade.getDtAlteracao());
		return dto;
	}

}
