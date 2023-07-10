package br.com.estudo.pessoas.microservico.repository.impl;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

@Repository
@PropertySource("classpath:query/pessoa-sql.properties")
public class PessoaRepositoryImpl implements PessoaRepository {

}
