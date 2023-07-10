package br.com.estudo.pessoas.microservico.util;

/**
 * @author hendrix.schmidt
 *
 */
public class PessoaException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public PessoaException(String mensagem) {
		super(mensagem);
	}

}
