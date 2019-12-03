package com.db1start.cidades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.dto.EstadoFormDTO;
import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	// CRIAR

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}
	
	// BUSCAR
	
	public List<Estado> buscarTodosEstados() {
		return estadoRepository.findAll();
	}
	
	public Estado buscarEstadoPorId(Long id) {
		return estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Estado com id " + id + " nao encontrado no banco de dados."));
	}
	
	public Estado buscarEstadoPorNome(String nome) {
		return estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException("Estado com nome " + nome + " nao encontrado no banco de dados."));
	}
	
	// APAGAR

	public void apagarTodosEstados() {
		estadoRepository.deleteAll();
	}

	public void apagarEstadoPorId(Long id) {
		estadoRepository.deleteById(id);
	}
	
	// ATUALIZAR
	
	public Estado atualizarEstadoPorId(Long id, EstadoFormDTO estadoForm) {
		Estado estado = buscarEstadoPorId(id);
		estado.setNome(estadoForm.getNome());
		return estadoRepository.save(estado);
	}

}
