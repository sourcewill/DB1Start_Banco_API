package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.ContaDTO;
import com.db1start.cidades.domain.entity.Conta;

public class ContaAdapter {

	public static ContaDTO contaParaDTO(Conta conta) {
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(conta.getId());
		contaDTO.setAgencia(conta.getAgencia());
		contaDTO.setCliente(conta.getCliente());
		contaDTO.setHistoricoDeOperacoes(conta.getHistoricoDeOperacoes());
		contaDTO.setSaldo(conta.getSaldo());
		contaDTO.setStatus(conta.getStatus());
		return contaDTO;
	}

	public static List<ContaDTO> listaDeContasParaDTO(List<Conta> contas) {
		List<ContaDTO> listaDeContasDTO = new ArrayList<>();
		for (Conta conta : contas) {
			ContaDTO contaDTO = contaParaDTO(conta);
			listaDeContasDTO.add(contaDTO);
		}
		return listaDeContasDTO;
	}

}
