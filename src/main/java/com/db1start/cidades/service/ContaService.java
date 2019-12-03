package com.db1start.cidades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.dto.ContaFormDTO;
import com.db1start.cidades.domain.dto.OperacaoFormDTO;
import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.domain.entity.StatusConta;
import com.db1start.cidades.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	public Conta criar(ContaFormDTO contaForm) {
		Cliente cliente = clienteService.buscarClientePorId(contaForm.getIdCliente());
		Agencia agencia = agenciaService.buscarAgenciaPorId(contaForm.getIdAgencia());
		Conta conta = new Conta(cliente, agencia);
		return contaRepository.save(conta);
	}

	public Conta criar(Cliente cliente, Agencia agencia) {
		Conta conta = new Conta(cliente, agencia);
		return contaRepository.save(conta);
	}

	// BUSCAR

	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	public Conta buscarContaPorId(Long id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Conta com id " + id + " nao encontrada no banco de dados."));
	}

	public List<Conta> buscaTodasContasAtivas() {
		List<Conta> ativas = new ArrayList<>();
		for (Conta conta : contaRepository.findAll()) {
			if (conta.getStatus() == StatusConta.ATIVA) {
				ativas.add(conta);
			}
		}
		return ativas;
	}

	public List<Conta> buscaTodasContasInativas() {
		List<Conta> inativas = new ArrayList<>();
		for (Conta conta : buscaTodasContas()) {
			if (conta.getStatus() == StatusConta.INATIVA) {
				inativas.add(conta);
			}
		}
		return inativas;
	}

	// APAGAR

	public void apagarTodasContas() {
		contaRepository.deleteAll();
	}

	public void apagarContaPorId(Long id) {
		contaRepository.deleteById(id);
	}

	// OPERACOES
	
	public Conta depositar(OperacaoFormDTO operacaoForm) {
		Conta conta = buscarContaPorId(operacaoForm.getIdConta());
		conta.depositar(operacaoForm.getValor());
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta depositar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.depositar(valor);
		return contaRepository.save(conta); // Devolve a conta atualizada
	}
	
	public Conta sacar(OperacaoFormDTO operacaoForm) {
		Conta conta = buscarContaPorId(operacaoForm.getIdConta());
		conta.sacar(operacaoForm.getValor());
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta sacar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.sacar(valor);
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta ativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.ativar();
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta desativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.desativar();
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

}
