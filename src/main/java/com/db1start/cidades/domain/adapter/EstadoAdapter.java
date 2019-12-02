package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.EstadoDTO;
import com.db1start.cidades.domain.entity.Estado;

public class EstadoAdapter {
	
	public static EstadoDTO estadoParaDTO(Estado estado) {
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(estado.getId());
		estadoDTO.setNome(estado.getNome());
		return estadoDTO;
	}
	
	public static List<EstadoDTO> listaDeEstadoParaDTO(List<Estado> estados){
		List<EstadoDTO> listaDeEstadosDTO = new ArrayList<>();
		for(Estado estado : estados) {
			listaDeEstadosDTO.add(estadoParaDTO(estado));
		}
		return listaDeEstadosDTO;
	}

}
