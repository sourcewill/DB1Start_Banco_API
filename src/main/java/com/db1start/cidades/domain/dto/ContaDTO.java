package com.db1start.cidades.domain.dto;

import java.util.List;

import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.StatusConta;

public class ContaDTO {

	private Long id;
	private Double saldo;
	private Cliente cliente;
	private AgenciaDTO agenciaDTO;
	private List<OperacaoDTO> historicoDeOperacoesDTO;
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

	public AgenciaDTO getAgenciaDTO() {
		return agenciaDTO;
	}

	public void setAgenciaDTO(AgenciaDTO agenciaDTO) {
		this.agenciaDTO = agenciaDTO;
	}

	public List<OperacaoDTO> getHistoricoDeOperacoesDTO() {
		return historicoDeOperacoesDTO;
	}

	public void setHistoricoDeOperacoesDTO(List<OperacaoDTO> historicoDeOperacoesDTO) {
		this.historicoDeOperacoesDTO = historicoDeOperacoesDTO;
	}

	public StatusConta getStatus() {
		return status;
	}

	public void setStatus(StatusConta status) {
		this.status = status;
	}

}
