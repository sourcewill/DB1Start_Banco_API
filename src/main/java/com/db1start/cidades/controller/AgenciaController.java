package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.service.AgenciaService;

@RestController
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	@PostMapping("/agencia")
	public Agencia criarAgencia(@RequestBody Agencia agencia) {
		return agenciaService.criar(agencia.getNumeroAgencia(), agencia.getCidade(), agencia.getNumeroBanco());
	}

	// BUSCAR

	@GetMapping("/agencias")
	public List<Agencia> buscarTodosAgencias() {
		return agenciaService.buscarTodasAgencias();
	}

	@GetMapping("/agencia/{id}")
	public Agencia buscarAgenciaPorId(@PathVariable(value = "id") Long id) {
		return agenciaService.buscarAgenciaPorId(id);
	}

	// APAGAR

	@DeleteMapping("/agencias")
	public void apagarTodasAgencias() {
		agenciaService.apagarTodasAgencias();
	}

	@DeleteMapping("/agencia/{id}")
	public void apagarAgenciaPorId(@PathVariable(value = "id") Long id) {
		agenciaService.apagarAgenciaPorId(id);
	}

}
