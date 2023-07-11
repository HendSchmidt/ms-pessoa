package br.com.estudo.pessoas.microservico.util;

import static java.time.temporal.ChronoUnit.SECONDS;
import static java.util.Objects.nonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class PessoaUtil {
	public static final String USUARIO_PADRAO = "SISTEMA";
	public static final String DATETIME_FORMATO = "yyyy-MM-dd HH:mm:ss";
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
	}

	public static LocalDateTime dateTo(final @NotNull Date entrada) {

		return entrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static Long diferencaEmSegundo(final @NotNull LocalDateTime dtInicial,
			@NotNull final LocalDateTime dtFinal) {

		return SECONDS.between(dtInicial, dtFinal);
	}

	public static boolean foraDoRange(final LocalDateTime inicio, final LocalDateTime fim, final LocalDateTime valor) {
		return nonNull(inicio) && valor.isBefore(inicio) || nonNull(fim) && valor.isAfter(fim);
	}
	
	public static String paraJson(final Object obj) {
		String jsonFormatado = null;
		try {
			jsonFormatado = mapper.writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			throw new PessoaException("Erro ao converter o DTO para Json.", e.getMessage());
		}
		return jsonFormatado;
	}
}
