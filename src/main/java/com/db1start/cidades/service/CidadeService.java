package com.db1start.cidades.service;

import java.util.ArrayList;
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

	// CRIAR

	public Cidade criar(String nome, Estado uf) {
		Cidade cidade = new Cidade(nome, uf);
		return cidadeRepository.save(cidade);
	}

	// BUSCAR

	public List<Cidade> buscarTodasCidades() {
		return cidadeRepository.findAll();
	}

	public Cidade buscarCidadePorId(Long id) {
		return cidadeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cidade com id " + id + " nao encontrada no banco de dados."));
	}

	public Cidade buscarCidadePorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException("Cidade com nome " + nome + " nao encontrada no banco de dados."));
	}

	public List<Cidade> buscarTodasCidadesEmUmEstado(Estado estado) {
		List<Cidade> cidades = new ArrayList<>();
		for (Cidade cidade : buscarTodasCidades()) {
			if (cidade.getUf().equals(estado)) {
				cidades.add(cidade);
			}
		}
		return cidades;
	}

	// APAGAR

	public void apagarTodasCidades() {
		cidadeRepository.deleteAll();
	}

	public void apagarCidadePorId(Long id) {
		cidadeRepository.deleteById(id);
	}

}
