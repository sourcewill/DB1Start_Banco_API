package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.repository.CidadeRepository;

public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade criar(String nome, Estado uf) {
		Cidade cidade = new Cidade(nome, uf);
		return cidadeRepository.save(cidade);
	}
	
	public void limpar() {
		cidadeRepository.deleteAll();
	}

}
