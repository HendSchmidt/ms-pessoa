package br.com.estudo.pessoas.microservico.domain.jdbc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author hendrix.schmidt
 *
 */
public abstract class SistemaJdbcDomain extends JdbcDomain {
	private static final long serialVersionUID = 1L;
	
	private Boolean inAtivo;
	
	public SistemaJdbcDomain() {
		super();
		this.inAtivo = Boolean.TRUE;
	}

	public Boolean getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(Boolean inAtivo) {
		this.inAtivo = inAtivo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
