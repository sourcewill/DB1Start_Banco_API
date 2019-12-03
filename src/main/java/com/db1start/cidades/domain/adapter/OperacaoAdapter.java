package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.OperacaoDTO;
import com.db1start.cidades.domain.entity.Operacao;

public class OperacaoAdapter {
	
	public static OperacaoDTO operacaoParaDTO(Operacao operacao){
		OperacaoDTO operacaoDTO = new OperacaoDTO();
		operacaoDTO.setData(operacao.getData());
		operacaoDTO.setTipo(operacao.getTipo());
		operacaoDTO.setValor(operacao.getValor());
		return operacaoDTO;
	}
	
	public static List<OperacaoDTO> listaDeOperacoesParaDTO(List<Operacao> operacoes){
		List<OperacaoDTO> listaDeOperacoesDTO = new ArrayList<>();
		for(Operacao operacao: operacoes){
			listaDeOperacoesDTO.add(operacaoParaDTO(operacao));
		}
		return listaDeOperacoesDTO;
	}

}
