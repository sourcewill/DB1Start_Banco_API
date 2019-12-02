package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.adapter.EstadoAdapter;
import com.db1start.cidades.domain.dto.EstadoDTO;
import com.db1start.cidades.domain.dto.EstadoFormDTO;
import com.db1start.cidades.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	// CRIAR

	@PostMapping("/criar")
	public EstadoDTO criarEstado(@RequestBody EstadoFormDTO estadoForm) {
		return EstadoAdapter.estadoParaDTO(estadoService.criar(estadoForm.getNome()));
	}

	// BUSCAR

	@GetMapping("/buscartodos")
	public List<EstadoDTO> buscarTodosEstados() {
		return EstadoAdapter.listaDeEstadoParaDTO(estadoService.buscarTodosEstados());
	}

	@GetMapping("/buscarporid/{id}")
	public EstadoDTO buscarEstadoPorId(@PathVariable(value = "id") Long id) {
		return EstadoAdapter.estadoParaDTO(estadoService.buscarEstadoPorId(id));
	}

	@GetMapping("/buscarpornome/{nome}")
	public EstadoDTO buscarEstadoPorNome(@PathVariable(value = "nome") String nome) {
		return EstadoAdapter.estadoParaDTO(estadoService.buscarEstadoPorNome(nome));
	}

	// APAGAR

	@DeleteMapping("/apagartodos")
	public void apagarTodosEstados() {
		estadoService.apagarTodosEstados();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarEstadoPorId(@PathVariable(value = "id") Long id) {
		estadoService.apagarEstadoPorId(id);
	}

}
