package br.com.estudo.pessoas.microservico.domain.jdbc.pessoa;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.estudo.pessoas.microservico.domain.jdbc.SistemaJdbcDomain;

/**
 * @author hendrix.schmidt
 *
 */
public class Pessoa extends SistemaJdbcDomain {
	private static final long serialVersionUID = 1L;
	
	private Long idPessoa;
    private String nmNome;
    private String cdCpf;
    private String cdRg;
    private String dtNascimento;
    private String nmSexo;
    private String nmEstadoCivil;
    
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNmNome() {
		return nmNome;
	}
	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}
	public String getCdCpf() {
		return cdCpf;
	}
	public void setCdCpf(String cdCpf) {
		this.cdCpf = cdCpf;
	}
	public String getCdRg() {
		return cdRg;
	}
	public void setCdRg(String cdRg) {
		this.cdRg = cdRg;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getNmSexo() {
		return nmSexo;
	}
	public void setNmSexo(String nmSexo) {
		this.nmSexo = nmSexo;
	}
	public String getNmEstadoCivil() {
		return nmEstadoCivil;
	}
	public void setNmEstadoCivil(String nmEstadoCivil) {
		this.nmEstadoCivil = nmEstadoCivil;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
