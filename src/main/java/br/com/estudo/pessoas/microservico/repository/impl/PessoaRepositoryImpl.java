package br.com.estudo.pessoas.microservico.repository.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.estudo.pessoas.microservico.domain.jdbc.JdbcRepository;
import br.com.estudo.pessoas.microservico.domain.jdbc.pessoa.Pessoa;
import br.com.estudo.pessoas.microservico.repository.PessoaRepository;

/**
 * @author hendrix.schmidt
 *
 */
@Repository
@PropertySource("classpath:query/pessoa-sql.properties")
public class PessoaRepositoryImpl extends JdbcRepository implements PessoaRepository  {
	private final Logger log = LogManager.getLogger();
	
	@Value("${SPI.PESSOA}")
	private String criar;
	
	@Value("${SPU.PESSOA}")
	private String atualizar;
	
	@Value("${SPS.PESSOA.POR.ID}")
	private String recuperarPorId;
	
	@Value("${SPS.PESSOA}")
	private String listar;
	
	@Value("${SPS.PESSOA.VERIFICA_SE_EXISTE.POR.CD_CPF}")
	private String verificaSeExistePorCdCpf;
	
	@Override
	public Pessoa criar(final Pessoa entidade) {
		log.info("Gravando dados da pessoa {}.", entidade.getCdCpf());
		final KeyHolder kh = new GeneratedKeyHolder();
		npjt.update(criar, new BeanPropertySqlParameterSource(entidade), kh);
		
		try {
			entidade.setIdPessoa(Objects.requireNonNull(kh.getKey()).longValue());
			return entidade;
		} catch (final DataRetrievalFailureException e) {
			return null;
		}
	}
	
	@Override
	public Pessoa atualizar(final Pessoa entidade) {
		npjt.update(atualizar, new BeanPropertySqlParameterSource(entidade));
		
		return entidade;
	}
	
	@Override
	public Optional<Pessoa> recuperarPorId(final Long id) {
 		final MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("idPessoa", id);
		
		return npjt.query(recuperarPorId, parametros, BeanPropertyRowMapper.newInstance(Pessoa.class))
				.stream().findFirst();
	}
	
	@Override
	public Boolean verificaSeExistePorCdCpf(final String cdCpf) {
 		final MapSqlParameterSource parametros = new MapSqlParameterSource();
		parametros.addValue("cdCpf", cdCpf);
		
		return npjt.queryForObject(verificaSeExistePorCdCpf, parametros, Boolean.class);
	}
	
	@Override
	public List<Pessoa> listar() {
		return npjt.query(listar, BeanPropertyRowMapper.newInstance(Pessoa.class));
	}
}
