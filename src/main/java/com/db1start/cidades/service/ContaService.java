package com.db1start.cidades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.domain.entity.StatusConta;
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
	
	public void apagarContaPorId(Long id) {
		contaRepository.deleteById(id);
	}
	
	public Conta buscarContaPorId(Long id) {
		return contaRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Conta com id " + id + " nao encontrada no banco de dados."));
	}
	
	public List<Conta> buscaTodasContas(){
		return contaRepository.findAll();
	}
	
	public List<Conta> buscaTodasContasAtivas(){
		List<Conta> ativas = new ArrayList<>();
		for(Conta conta : contaRepository.findAll()) {
			if(conta.getStatus() == StatusConta.ATIVA) {
				ativas.add(conta);
			}
		}
		return ativas;
	}
	
	public List<Conta> buscaTodasContasInativas(){
		List<Conta> inativas = new ArrayList<>();
		for(Conta conta : buscaTodasContas()) {
			if(conta.getStatus() == StatusConta.INATIVA) {
				inativas.add(conta);
			}
		}
		return inativas;
	}
	
	@Transactional
	public Conta depositar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.depositar(valor);
		return conta; //Devolve a conta atualizada
	}
	
	@Transactional
	public Conta sacar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.sacar(valor);
		return conta; //Devolve a conta atualizada
	}
	
	@Transactional
	public Conta ativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.ativar();
		return conta; //Devolve a conta atualizada
	}
	
	@Transactional
	public Conta desativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.desativar();
		return conta; //Devolve a conta atualizada
	}
	
	

}
