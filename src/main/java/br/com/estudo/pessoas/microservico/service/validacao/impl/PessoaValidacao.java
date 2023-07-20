package br.com.estudo.pessoas.microservico.service.validacao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * Responsavel por orquestrar todas as validações de pessoa.
 * 
 * @author hendrix.schmidt
 *
 */
@Service
public class PessoaValidacao  {
	
	@Autowired
	private ValidadorDeCpf validaCpf;
	
	@Autowired
	private ValidadorDeNome validaNome;
	
	@Autowired
	private ValidadorBO validadorDeRegraDeNegocio;

	public void validarParaCriacao(PessoaDto dto, PessoaRepository repository) {
		validaCpf.validar(dto);
		validaNome.validar(dto);
		validadorDeRegraDeNegocio.validarParaCriacao(dto, repository);
	}

	public void validarParaAtualizacao(PessoaDto dto, PessoaRepository repository) {
		validaCpf.validar(dto);
		validadorDeRegraDeNegocio.validarParaAtualizacao(dto, repository);
		
	}

	public void validarParaExclusao(PessoaDto dto, PessoaRepository repository) {
		validaCpf.validar(dto);
		validadorDeRegraDeNegocio.validarParaExclusao(dto, repository);
	}


}
