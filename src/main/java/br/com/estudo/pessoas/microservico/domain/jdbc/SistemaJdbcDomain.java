package br.com.estudo.pessoas.microservico.domain.jdbc;

import static br.com.estudo.pessoas.microservico.util.PessoaUtil.USUARIO_PADRAO;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author hendrix.schmidt
 *
 */
public abstract class SistemaJdbcDomain extends JdbcDomain {
	private static final long serialVersionUID = 1L;
	
	private Boolean inAtivo;
	private String nmUsuario;
	
	public SistemaJdbcDomain() {
		super();
		this.inAtivo = Boolean.TRUE;
		this.nmUsuario = USUARIO_PADRAO;
	}

	public Boolean getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(Boolean inAtivo) {
		this.inAtivo = inAtivo;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
