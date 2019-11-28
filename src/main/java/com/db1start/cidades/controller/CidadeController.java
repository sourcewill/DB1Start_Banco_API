package com.db1start.cidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.service.CidadeService;

@RestController
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	// CRIAR

	@PostMapping("/cidade")
	public Cidade criarCidade(@RequestBody String nome, @RequestBody Estado uf) {
		return cidadeService.criar(nome, uf);
	}

	// BUSCAR

	@GetMapping("/cidades")
	public List<Cidade> buscarTodosCidades() {
		return cidadeService.buscarTodasCidades();
	}

	@GetMapping("/cidade/{id}")
	public Cidade buscarCidadePorId(@PathVariable(value = "id") Long id) {
		return cidadeService.buscarCidadePorId(id);
	}

	@GetMapping("/cidade/{nome}")
	public Cidade buscarCidadePorNome(@PathVariable(value = "nome") String nome) {
		return cidadeService.buscarCidadePorNome(nome);
	}

	// APAGAR

	@DeleteMapping("/cidades")
	public void apagarTodasCidades() {
		cidadeService.apagarTodasCidades();
	}

	@DeleteMapping("/cidade/{id}")
	public void apagarCidadePorId(@PathVariable(value = "id") Long id) {
		cidadeService.apagarCidadePorId(id);
	}

}
