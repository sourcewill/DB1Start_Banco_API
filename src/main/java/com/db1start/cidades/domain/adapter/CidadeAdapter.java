package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.CidadeDTO;
import com.db1start.cidades.domain.entity.Cidade;

public class CidadeAdapter {
	
	public static CidadeDTO cidadeParaDTO(Cidade cidade) {
		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setId(cidade.getId());
		cidadeDTO.setNome(cidade.getNome());
		cidadeDTO.setUf(cidade.getUf());
		return cidadeDTO;
	}
	
	public static List<CidadeDTO> listaDeCidadeParaDTO(List<Cidade> cidades){
		List<CidadeDTO> listaDeCidadesDTO = new ArrayList<>();
		for(Cidade cidade : cidades) {
			CidadeDTO cidadeDTO = cidadeParaDTO(cidade);
			listaDeCidadesDTO.add(cidadeDTO);
		}
		return listaDeCidadesDTO;
	}

}
