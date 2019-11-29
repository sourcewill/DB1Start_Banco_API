package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.service.EstadoService;

@RestController
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	// CRIAR

	@PostMapping("/estado")
	public Estado criarEstado(@RequestBody Estado estado) {
		return estadoService.criar(estado.getNome());
	}

	// BUSCAR

	@GetMapping("/estados")
	public List<Estado> buscarTodosEstados() {
		return estadoService.buscarTodosEstados();
	}

	@GetMapping("/estado/{id}")
	public Estado buscarEstadoPorId(@PathVariable(value = "id") Long id) {
		return estadoService.buscarEstadoPorId(id);
	}

	// APAGAR

	@DeleteMapping("/estados")
	public void apagarTodosEstados() {
		estadoService.apagarTodosEstados();
	}

	@DeleteMapping("/estado/{id}")
	public void apagarEstadoPorId(@PathVariable(value = "id") Long id) {
		estadoService.apagarEstadoPorId(id);
	}

}
