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

import com.db1start.cidades.domain.adapter.CidadeAdapter;
import com.db1start.cidades.domain.dto.CidadeDTO;
import com.db1start.cidades.domain.dto.CidadeFormDTO;
import com.db1start.cidades.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	// CRIAR

	@PostMapping("/criar")
	public CidadeDTO criarCidade(@RequestBody CidadeFormDTO cidadeForm) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.criar(cidadeForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<CidadeDTO> buscarTodosCidades() {
		return CidadeAdapter.listaDeCidadeParaDTO(cidadeService.buscarTodasCidades());
	}

	@GetMapping("/buscarporid/{id}")
	public CidadeDTO buscarCidadePorId(@PathVariable(value = "id") Long id) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.buscarCidadePorId(id));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasCidades() {
		cidadeService.apagarTodasCidades();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarCidadePorId(@PathVariable(value = "id") Long id) {
		cidadeService.apagarCidadePorId(id);
	}

}
