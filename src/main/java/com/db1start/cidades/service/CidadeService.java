package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.repository.CidadeRepository;

@Service
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
	
	public Cidade buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException("Cidade com nome " + nome + " nao encontrada no banco de dados."));
	}

}
