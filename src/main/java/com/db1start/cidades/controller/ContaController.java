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

import com.db1start.cidades.domain.adapter.ContaAdapter;
import com.db1start.cidades.domain.dto.ContaDTO;
import com.db1start.cidades.domain.dto.ContaFormDTO;
import com.db1start.cidades.service.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	// CRIAR

	@PostMapping("/criar")
	public ContaDTO criarConta(@RequestBody ContaFormDTO contaForm) {
		return ContaAdapter.contaParaDTO(contaService.criar(contaForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<ContaDTO> buscarTodasContas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContas());
	}

	@GetMapping("/ativas")
	public List<ContaDTO> buscarTodasContasAtivas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasAtivas());
	}

	@GetMapping("/inativas")
	public List<ContaDTO> buscarTodasContasInativas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasInativas());
	}

	@GetMapping("/buscarporid/{id}")
	public ContaDTO buscarContaPorId(@PathVariable(value = "id") Long id) {
		return ContaAdapter.contaParaDTO(contaService.buscarContaPorId(id));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasContas() {
		contaService.apagarTodasContas();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarContaPorId(@PathVariable(value = "id") Long id) {
		contaService.apagarContaPorId(id);
	}

}
