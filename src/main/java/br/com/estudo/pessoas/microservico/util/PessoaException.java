package br.com.estudo.pessoas.microservico.util;

/**
 * @author hendrix.schmidt
 *
 */
public class PessoaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	private transient Object detalhe;
	
	public PessoaException() {
		
	}
	
	public PessoaException(String mensagem) {
		super(mensagem);
	}

	public PessoaException(String mensagem, String detalhe) {
		super();
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}
	
	@Override
	public String toString() {
		return String.format("ERRO [mensagem=%s, detalhe=%s]", mensagem, detalhe);
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(final String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(final Object detalhe) {
		this.detalhe = detalhe;
	}

}
