package com.db1start.cidades.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conta> contas;

	public Agencia(String numeroAgencia, Cidade cidade, String numeroBanco) {
		this.numeroAgencia = numeroAgencia;
		this.cidade = cidade;
		this.numeroBanco = numeroBanco;
		this.contas = new ArrayList<>();
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

	public List<Conta> getContas() {
		return contas;
	}

}
