package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<String> validar(PessoaDto dto, PessoaRepository repository) {
		List<String> lsErro = new ArrayList<>();
		
		lsErro = lsPessoaValidacao.parallelStream().map(v -> v.validar(dto)).collect(Collectors.toList());
		
		if(lsErro.parallelStream().allMatch(t -> t.isEmpty() || t.isBlank()))
			lsErro = lsValidacaoBO.stream().map(v -> v.validar(dto, repository)).collect(Collectors.toList());
		
		return lsErro;
	}

}
