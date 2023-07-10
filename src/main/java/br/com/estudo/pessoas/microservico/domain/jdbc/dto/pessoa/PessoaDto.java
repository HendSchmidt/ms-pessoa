package br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa;

import javax.validation.constraints.NotBlank;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.SistemaWebDto;

/**
 * @author hendrix.schmidt
 *
 */
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
}
