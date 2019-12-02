package com.db1start.cidades.domain.dto;

import com.db1start.cidades.domain.entity.TipoOperacao;

public class OperacaoDTO {

	private Long id;
	private TipoOperacao tipo;
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
