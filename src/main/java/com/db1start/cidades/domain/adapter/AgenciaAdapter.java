package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.AgenciaDTO;
import com.db1start.cidades.domain.entity.Agencia;

public class AgenciaAdapter {

	
	public static AgenciaDTO agenciaParaDTO(Agencia agencia) {
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		agenciaDTO.setId(agencia.getId());
		agenciaDTO.setCidade(agencia.getCidade());
		agenciaDTO.setNumeroAgencia(agencia.getNumeroAgencia());
		agenciaDTO.setNumeroBanco(agencia.getNumeroBanco());
		return agenciaDTO;
	}
	
	public static List<AgenciaDTO> listaDeAgenciasParaDTO(List<Agencia> agencias){
		List<AgenciaDTO> listaDeAgenciasDTO = new ArrayList<>();
		for(Agencia agencia : agencias) {
			AgenciaDTO agenciaDTO = agenciaParaDTO(agencia);
			listaDeAgenciasDTO.add(agenciaDTO);
		}
		return listaDeAgenciasDTO;
	}
}
