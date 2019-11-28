package com.db1start.cidades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente criar(String nome, String cpf) {
		Cliente cliente = new Cliente(nome, cpf);
		return clienteRepository.save(cliente);
	}

	public void limpar() {
		clienteRepository.deleteAll();
	}

	public Cliente buscarClientePorNome(String nome) {
		return clienteRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException("Cliente com nome " + nome + " nao encontrado no banco de dados."));
	}

	public void apagarClientePorNome(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente com id " + id + " nao encontrado no banco de dados."));
	}

	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

}
