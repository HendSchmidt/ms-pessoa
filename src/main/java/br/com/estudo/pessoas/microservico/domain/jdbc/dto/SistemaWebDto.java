package br.com.estudo.pessoas.microservico.domain.jdbc.dto;


import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hendrix.schmidt
 *
 */
public class SistemaWebDto extends SistemaDto {
	private static final long serialVersionUID = 1L;
	
	private transient HttpHeaders header;
	private transient HttpServletRequest request;
	
	public SistemaWebDto(HttpHeaders header) {
		this();
		this.header = header;
	}
	
	public SistemaWebDto() {
		super();
	}
	public HttpHeaders getHeader() {
		return header;
	}
	public void setHeader(HttpHeaders header) {
		this.header = header;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
