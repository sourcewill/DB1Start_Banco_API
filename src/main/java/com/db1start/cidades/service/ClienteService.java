package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.repository.ClienteRepository;

public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

}
