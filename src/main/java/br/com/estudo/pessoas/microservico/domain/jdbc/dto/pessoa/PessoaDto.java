package br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.SistemaWebDto;

/**
 * @author hendrix.schmidt
 *
 */

@JsonInclude(Include.NON_NULL)
public class PessoaDto extends SistemaWebDto {
	private static final long serialVersionUID = 1L;

	private Long idPessoa;
	
	@NotBlank(message = "Nome invalido, não pode ser vazio ou nulo")
	private String nmNome;
	
	@NotBlank(message = "CPF invalido, não pode ser vazio ou nulo")
	private String cdCpf;
	private String cdRg;
	
	@NotBlank(message = "Data de nascimento invalido, não pode ser vazio ou nulo")
	private String dtNascimento;
	private String nmSexo;
	private String nmEstadoCivil;
	private Boolean inAtivo;
	private LocalDateTime dtCriacao;
	private LocalDateTime dtAlteracao;
	
	public PessoaDto() {}

	public PessoaDto(Long idPessoa, String nmNome, String cdCpf, String cdRg, String dtNascimento, String nmSexo,
			String nmEstadoCivil) {
		this.idPessoa = idPessoa;
		this.nmNome = nmNome;
		this.cdCpf = cdCpf;
		this.cdRg = cdRg;
		this.dtNascimento = dtNascimento;
		this.nmSexo = nmSexo;
		this.nmEstadoCivil = nmEstadoCivil;
	}

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

	public Boolean getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(Boolean inAtivo) {
		this.inAtivo = inAtivo;
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
