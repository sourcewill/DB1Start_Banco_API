package com.db1start.cidades.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numeroAgencia")
	private String numeroAgencia;

	@ManyToOne
	@JoinColumn
	private Cidade cidade;

	@Column(name = "numeroBanco")
	private String numeroBanco;

	public Agencia(String numeroAgencia, Cidade cidade, String numeroBanco) {

		if (numeroAgencia == null) {
			throw new RuntimeException("numeroAgencia nao pode ser nulo");
		}
		if (cidade == null) {
			throw new RuntimeException("cidade nao pode ser nula");
		}
		if (numeroBanco == null) {
			throw new RuntimeException("numeroBanco nao pode ser nulo");
		}

		this.numeroAgencia = numeroAgencia;
		this.cidade = cidade;
		this.numeroBanco = numeroBanco;
	}

	public Agencia() {

	}

	public Long getId() {
		return id;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

}
