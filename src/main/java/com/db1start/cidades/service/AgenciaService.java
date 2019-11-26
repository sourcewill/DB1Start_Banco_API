package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.repository.AgenciaRepository;

public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia criar(String numeroAgencia, Cidade cidade, String numeroBanco) {
		Agencia agencia = new Agencia(numeroAgencia, cidade, numeroBanco);
		return agenciaRepository.save(agencia);
	}
	
	public void limpar() {
		agenciaRepository.deleteAll();
	}

}
