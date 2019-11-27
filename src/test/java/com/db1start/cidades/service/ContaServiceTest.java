package com.db1start.cidades.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaServiceTest {

	@Autowired
	private ContaService contaService;

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private ClienteService clienteService;
	
	private void clean() {
		contaService.limpar();
		agenciaService.limpar();
		cidadeService.limpar();
		estadoService.limpar();
	}

	@Test
	public void deveCriarNovaConta() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		Agencia agencia = agenciaService.criar("123", cidade, "123");
		Cliente cliente = clienteService.criar("William", "123");
		Conta conta = contaService.criar(cliente, agencia);
		
		assertNotNull(conta);
		clean();
	}
	
	@Test
	public void deveDeletarContaPorId() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		Agencia agencia = agenciaService.criar("123", cidade, "123");
		Cliente cliente = clienteService.criar("William", "123");
		Conta conta = contaService.criar(cliente, agencia);
		Long id = conta.getId();
		contaService.apagarConta(id);
		try {
			contaService.buscarPorId(id);
		} catch (Exception e) {
			assertEquals("Conta com id " + id + " nao encontrada no banco de dados.", e.getMessage());
		}
		clean();
	}

}
