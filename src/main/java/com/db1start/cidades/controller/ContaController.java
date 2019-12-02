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
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.service.ContaService;

@RestController
@RequestMapping("/api")
public class ContaController {

	@Autowired
	private ContaService contaService;

	// CRIAR

	@PostMapping("/conta")
	public ContaDTO criarConta(@RequestBody Conta conta) {
		return ContaAdapter.contaParaDTO(contaService.criar(conta.getCliente(), conta.getAgencia()));
	}

	// BUSCAR

	@GetMapping("/contas")
	public List<ContaDTO> buscarTodasContas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContas());
	}

	@GetMapping("/contas/ativas")
	public List<ContaDTO> buscarTodasContasAtivas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasAtivas());
	}

	@GetMapping("/contas/inativas")
	public List<ContaDTO> buscarTodasContasInativas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasInativas());
	}

	@GetMapping("/conta/{id}")
	public ContaDTO buscarContaPorId(@PathVariable(value = "id") Long id) {
		return ContaAdapter.contaParaDTO(contaService.buscarContaPorId(id));
	}

	// APAGAR

	@DeleteMapping("/contas")
	public void apagarTodasContas() {
		contaService.apagarTodasContas();
	}

	@DeleteMapping("/conta/{id}")
	public void apagarContaPorId(@PathVariable(value = "id") Long id) {
		contaService.apagarContaPorId(id);
	}

}
