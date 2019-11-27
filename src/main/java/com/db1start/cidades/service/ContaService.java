package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criar(Cliente cliente, Agencia agencia) {
		Conta conta = new Conta(cliente, agencia);
		return contaRepository.save(conta);
	}
	
	public void limpar() {
		contaRepository.deleteAll();
	}
	
	public void apagarConta(Long id) {
		contaRepository.deleteById(id);
	}
	
	public Conta buscarPorId(Long id) {
		return contaRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Conta com id " + id + " nao encontrada no banco de dados."));
	}

}
