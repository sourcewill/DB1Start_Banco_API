package com.db1start.cidades.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "saldo")
	private Double saldo;

	@OneToOne
	private Cliente cliente;

	@ManyToOne
	@JoinColumn
	private Agencia agencia;

	@Column(name = "status")
	private StatusConta status;

	public Conta(Cliente cliente, Agencia agencia) {

		if (cliente == null) {
			throw new RuntimeException("cliente nao pode ser nulo");
		}
		if (agencia == null) {
			throw new RuntimeException("agencia nao pode ser nula");
		}

		this.saldo = 0.0;
		this.cliente = cliente;
		this.agencia = agencia;
		this.status = StatusConta.ATIVA;
	}

	public Conta() {

	}

	public Long getId() {
		return id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public StatusConta getStatus() {
		return status;
	}

	public void depositar(Double valor) {

		if (valor == null) {
			throw new RuntimeException("Valor nao pode ser nulo.");
		}
		if (valor <= 0) {
			throw new RuntimeException("Valor deve ser maior que zero.");
		}

		this.saldo += valor;
	}

	public void sacar(Double valor) {

		if (valor == null) {
			throw new RuntimeException("Valor nao pode ser nulo.");
		}
		if (valor <= 0) {
			throw new RuntimeException("Valor deve ser maior que zero.");
		}
		if (valor > this.saldo) {
			throw new RuntimeException("Valor é maior do que o saldo atual.");
		}

		this.saldo -= valor;
	}

	public void ativar() {

		if (status == StatusConta.ATIVA) {
			throw new RuntimeException("A conta já está ativa.");
		}

		this.status = StatusConta.ATIVA;
	}

	public void desaativar() {

		if (status == StatusConta.INATIVA) {
			throw new RuntimeException("A conta já está desativada.");
		}

		this.status = StatusConta.INATIVA;
	}

}
