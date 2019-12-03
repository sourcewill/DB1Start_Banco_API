package com.db1start.cidades.domain.dto;

import java.util.Date;

import com.db1start.cidades.domain.entity.TipoOperacao;

public class OperacaoDTO {

	private Date data;
	private TipoOperacao tipo;
	private Double valor;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
