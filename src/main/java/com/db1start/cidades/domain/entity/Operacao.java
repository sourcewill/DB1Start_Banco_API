package com.db1start.cidades.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operacao")
public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Conta conta;

	@Column(name = "data")
	private Date data;

	@Column(name = "tipo")
	private TipoOperacao tipo;

	@Column(name = "valor")
	private Double valor;

	public Operacao(Conta conta, Date data, TipoOperacao tipo, Double valor) {
		this.conta = conta;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Operacao() {
	}

	public Date getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public Conta getConta() {
		return conta;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valor;
	}

}
