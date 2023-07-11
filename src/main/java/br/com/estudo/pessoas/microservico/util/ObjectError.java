package br.com.estudo.pessoas.microservico.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author hendrix.schmidt
 *
 */
@JsonInclude(Include.NON_NULL)
public class ObjectError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object erro;
	private Object classe;
	private Object causa;
	private Object stackTrace;

	public Object getErro() {
		return erro;
	}

	public void setErro(Object erro) {
		this.erro = erro;
	}

	public Object getCausa() {
		return causa;
	}

	public void setCausa(Object causa) {
		this.causa = causa;
	}

	public Object getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(Object stackTrace) {
		this.stackTrace = stackTrace;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	public Object getClasse() {
		return classe;
	}

	public void setClasse(Object classe) {
		this.classe = classe;
	}
}
