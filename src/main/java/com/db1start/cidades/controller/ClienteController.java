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

import com.db1start.cidades.domain.adapter.ClienteAdapter;
import com.db1start.cidades.domain.dto.ClienteDTO;
import com.db1start.cidades.domain.dto.ClienteFormDTO;
import com.db1start.cidades.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// CRIAR

	@PostMapping("/criar")
	public ClienteDTO criarEstado(@RequestBody ClienteFormDTO clienteForm) {
		return ClienteAdapter.clienteParaDTO(clienteService.criar(clienteForm.getNome(), clienteForm.getCpf()));
	}

	// BUSCAR

	@GetMapping("/buscartodos")
	public List<ClienteDTO> buscarTodosClientes() {
		return ClienteAdapter.listaDeClienteParaDTO(clienteService.buscarTodosClientes());
	}

	@GetMapping("/buscarporid/{id}")
	public ClienteDTO buscarClientePorId(@PathVariable(value = "id") Long id) {
		return ClienteAdapter.clienteParaDTO(clienteService.buscarClientePorId(id));
	}

	// APAGAR

	@DeleteMapping("/apagartodos")
	public void apagarTodosClientes() {
		clienteService.apagarTodosClientes();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarClientePorId(@PathVariable(value = "id") Long id) {
		clienteService.apagarClientePorId(id);
	}
	
	// ATUALIZAR
	
	@PutMapping("/atualizar/{id}")
	public ClienteDTO atualizar(@PathVariable(value = "id") Long id, ClienteFormDTO clienteForm) {
		return ClienteAdapter.clienteParaDTO(clienteService.atualizar(id, clienteForm));
	}

}
