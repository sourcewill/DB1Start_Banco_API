package com.db1start.cidades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public void limpar() {
		estadoRepository.deleteAll();
	}

	public Estado buscarPorNome(String nome) {
		return estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException("Estado com nome " + nome + " nao encontrado no banco de dados."));
	}

	public void apagarEstado(Long id) {
		estadoRepository.deleteById(id);
	}

	public Estado buscarPorId(Long id) {
		return estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estado com id " + id + " nao encontrado no banco de dados."));
	}

	public List<Estado> buscarTodosEstados() {
		return estadoRepository.findAll();
	}

}
