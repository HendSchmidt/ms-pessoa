package br.com.estudo.pessoas.microservico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.estudo.pessoas.microservico.domain.jdbc.pessoa.Pessoa;

@Repository
public interface PessoaRepository {

	Pessoa criar(Pessoa entidade);

	void atualizar(Pessoa entidade);

	Optional<Pessoa> recuperarPorcdCpf(final String cdCpf);

	List<Pessoa> listar();

	Boolean verificaSeExistePorCdCpf(String cdCpf);

	void excluirPorCpf(String cdCpf);

}
