package br.com.estudo.pessoas.microservico.service.validacao.impl;

import java.util.Map;

import br.com.estudo.pessoas.microservico.domain.jdbc.dto.pessoa.PessoaDto;

/**
 * @author hendrix.schmidt
 *
 */
public abstract class CorrenteDeValidacaoDeCpf {
	
	protected CorrenteDeValidacaoDeCpf proximo;
	
	public CorrenteDeValidacaoDeCpf(CorrenteDeValidacaoDeCpf proximo) {
		super();
		this.proximo = proximo;
	}

	public String validar(PessoaDto dto) {
		final Map<Boolean, String> cpfValidado = valida(dto);
		if(cpfValidado.containsKey(true)) {
			return cpfValidado.get(true);
		}
		
		return proximo.validar(dto);
	}
	
	public abstract Map<Boolean, String> valida(PessoaDto dto);

	protected boolean verificaDigito(String cpf, int peso, int posicaoDigito) {
		int digitoCalculado = calcularDigitoVerificador(cpf.substring(0, posicaoDigito), peso);
		int digitoFornecido = Character.getNumericValue(cpf.charAt(posicaoDigito));
		return digitoCalculado == digitoFornecido;
	}

	protected static int calcularDigitoVerificador(String cpf, int peso) {
		int soma = 0;
		for (int i = 0; i < cpf.length(); i++) {
			soma += Character.digit(cpf.charAt(i), 10) * peso--;
		}
		int resto = soma % 11;
		return (resto < 2) ? 0 : 11 - resto;
	}

}
