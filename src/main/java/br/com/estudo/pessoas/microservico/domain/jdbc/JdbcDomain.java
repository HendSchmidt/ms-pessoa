package br.com.estudo.pessoas.microservico.domain.jdbc;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static java.time.LocalDateTime.now;

/**
 * @author hendrix.schmidt
 *
 */
public abstract class JdbcDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
    protected LocalDateTime dtCriacao;
    protected LocalDateTime dtAlteracao;
    
	public JdbcDomain() {
		super();
		this.dtCriacao = now();
	}

	public LocalDateTime getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDateTime dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public LocalDateTime getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(LocalDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
