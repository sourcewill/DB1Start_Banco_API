package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.AgenciaDTO;
import com.db1start.cidades.domain.dto.CidadeDTO;
import com.db1start.cidades.domain.entity.Agencia;

public class AgenciaAdapter {

	
	public static AgenciaDTO agenciaParaDTO(Agencia agencia) {
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		agenciaDTO.setId(agencia.getId());
		CidadeDTO cidadeDTO = CidadeAdapter.cidadeParaDTO(agencia.getCidade());
		agenciaDTO.setCidadeDTO(cidadeDTO);
		agenciaDTO.setNumeroAgencia(agencia.getNumeroAgencia());
		agenciaDTO.setNumeroBanco(agencia.getNumeroBanco());
		return agenciaDTO;
	}
	
	public static List<AgenciaDTO> listaDeAgenciasParaDTO(List<Agencia> agencias){
		List<AgenciaDTO> listaDeAgenciasDTO = new ArrayList<>();
		for(Agencia agencia : agencias) {
			listaDeAgenciasDTO.add(agenciaParaDTO(agencia));
		}
		return listaDeAgenciasDTO;
	}
}
