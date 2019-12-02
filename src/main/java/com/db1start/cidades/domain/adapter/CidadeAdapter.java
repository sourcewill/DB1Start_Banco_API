package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.CidadeDTO;
import com.db1start.cidades.domain.dto.EstadoDTO;
import com.db1start.cidades.domain.entity.Cidade;

public class CidadeAdapter {
	
	public static CidadeDTO cidadeParaDTO(Cidade cidade) {
		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setId(cidade.getId());
		cidadeDTO.setNome(cidade.getNome());
		EstadoDTO estadoDTO = EstadoAdapter.estadoParaDTO(cidade.getUf());
		cidadeDTO.setEstadoDTO(estadoDTO);
		return cidadeDTO;
	}
	
	public static List<CidadeDTO> listaDeCidadeParaDTO(List<Cidade> cidades){
		List<CidadeDTO> listaDeCidadesDTO = new ArrayList<>();
		for(Cidade cidade : cidades) {
			listaDeCidadesDTO.add(cidadeParaDTO(cidade));
		}
		return listaDeCidadesDTO;
	}

}
