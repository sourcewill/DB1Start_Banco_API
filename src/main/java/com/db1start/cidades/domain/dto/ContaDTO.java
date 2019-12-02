package com.db1start.cidades.domain.dto;

import java.util.List;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Operacao;
import com.db1start.cidades.domain.entity.StatusConta;

public class ContaDTO {

	private Long id;
	private Double saldo;
	private Cliente cliente;
	private Agencia agencia;
	private List<Operacao> historicoDeOperacoes;
	private StatusConta status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<Operacao> getHistoricoDeOperacoes() {
		return historicoDeOperacoes;
	}

	public void setHistoricoDeOperacoes(List<Operacao> historicoDeOperacoes) {
		this.historicoDeOperacoes = historicoDeOperacoes;
	}

	public StatusConta getStatus() {
		return status;
	}

	public void setStatus(StatusConta status) {
		this.status = status;
	}

}
