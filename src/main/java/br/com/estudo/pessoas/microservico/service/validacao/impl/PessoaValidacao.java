package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;
import br.com.estudo.pessoas.microservico.service.validacao.ValidadorDeDadosDePessoa;

/**
 * Responsavel por orquestrar todas as validações de pessoa.
 * 
 * @author hendrix.schmidt
 *
 */
@Service
public class PessoaValidacao  {
	
	@Autowired
	private List<ValidadorDeDadosDePessoa> lsPessoaValidacao;
	
	@Autowired
	private List<ValidadorDeRegrasDeNegocio> lsValidacaoBO;

	public void validar(PessoaDto dto, PessoaRepository repository) {
		
		lsPessoaValidacao.stream().forEachOrdered(v -> v.validar(dto));
		lsValidacaoBO.stream().forEachOrdered(v -> v.validar(dto, repository));
	}

}
