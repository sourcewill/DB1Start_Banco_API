package com.db1start.cidades.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidades.domain.entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	private void clean() {
		clienteService.limpar();
	}

	@Test
	public void deveCriarNovoCliente() {
		Cliente cliente = clienteService.criar("William", "123");
		assertNotNull(cliente);
		System.out.println("Cliente: " + cliente.getNome());
		clean();
	}
	
	@Test
	public void deveDeletarClientePorId() {
		Cliente cliente = clienteService.criar("William", "123");
		Long id = cliente.getId();
		clienteService.apagarClientePorNome(id);
		try {
			clienteService.buscarClientePorId(id);
		} catch (Exception e) {
			assertEquals("Cliente com id " + id + " nao encontrado no banco de dados.", e.getMessage());
		}
	}

}
