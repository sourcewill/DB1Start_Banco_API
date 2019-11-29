package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.service.ContaService;

@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;

	// CRIAR

	@PostMapping("/conta")
	public Conta criarConta(@RequestBody Conta conta) {
		return contaService.criar(conta.getCliente(), conta.getAgencia());
	}

	// BUSCAR

	@GetMapping("/contas")
	public List<Conta> buscarTodasContas() {
		return contaService.buscaTodasContas();
	}

	@GetMapping("/contas/ativas")
	public List<Conta> buscarTodasContasAtivas() {
		return contaService.buscaTodasContasAtivas();
	}

	@GetMapping("/contas/inativas")
	public List<Conta> buscarTodasContasInativas() {
		return contaService.buscaTodasContasInativas();
	}

	@GetMapping("/conta/{id}")
	public Conta buscarContaPorId(@PathVariable(value = "id") Long id) {
		return contaService.buscarContaPorId(id);
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
