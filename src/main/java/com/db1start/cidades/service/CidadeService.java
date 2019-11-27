package com.db1start.cidades.service;

import java.util.List;

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
	
	public void apagarCidade(Long id) {
		cidadeRepository.deleteById(id);
	}
	
	public Cidade buscarPorId(Long id) {
		return cidadeRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Cidade com id " + id + " nao encontrada no banco de dados."));
	}
	
	public List<Cidade> buscarTodas(){
		return cidadeRepository.findAll();
	}
	

}
