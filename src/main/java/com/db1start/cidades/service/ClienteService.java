package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.repository.ClienteRepository;

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

}
