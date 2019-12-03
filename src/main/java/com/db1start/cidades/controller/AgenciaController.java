package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.adapter.AgenciaAdapter;
import com.db1start.cidades.domain.dto.AgenciaDTO;
import com.db1start.cidades.domain.dto.AgenciaFormDTO;
import com.db1start.cidades.service.AgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	@PostMapping("/criar")
	public AgenciaDTO criarAgencia(@RequestBody AgenciaFormDTO agenciaForm) {
		return AgenciaAdapter.agenciaParaDTO(
				agenciaService.criar(agenciaForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<AgenciaDTO> buscarTodosAgencias() {
		return AgenciaAdapter.listaDeAgenciasParaDTO(agenciaService.buscarTodasAgencias());
	}

	@GetMapping("/buscarporid/{id}")
	public AgenciaDTO buscarAgenciaPorId(@PathVariable(value = "id") Long id) {
		return AgenciaAdapter.agenciaParaDTO(agenciaService.buscarAgenciaPorId(id));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasAgencias() {
		agenciaService.apagarTodasAgencias();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarAgenciaPorId(@PathVariable(value = "id") Long id) {
		agenciaService.apagarAgenciaPorId(id);
	}
	
	// ATUALIZAR
	
	@PutMapping("/atualizar/{id}")
	public AgenciaDTO atualizar(@PathVariable(value = "id") Long id, @RequestBody AgenciaFormDTO agenciaForm) {
		return AgenciaAdapter.agenciaParaDTO(agenciaService.atualizar(id, agenciaForm));
	}

}
