package com.db1start.cidades.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidades.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {

	@Autowired
	private EstadoService estadoService;
	
	private void clean() {
		estadoService.limpar();
	}
	
	@Test
	public void deveCriarNovoEstado() {
		Estado estado = estadoService.criar("Parana");
		assertNotNull(estado);
		System.out.println("ID do Estado: " + estado.getId());
		clean();
	}
	
	@Test
	public void deveBuscarEstadoPorNome() {
		estadoService.criar("Parana");
		Estado estado = estadoService.buscarEstadoPorNome("Parana");
		System.out.println("Nome do estado: " + estado.getNome());
		assertNotNull(estado);
		clean();
	}
	
	@Test
	public void deveLancarExcessaoDeEstadoNaoExiste() {
		try {
			estadoService.buscarEstadoPorNome("Acre");
		} catch (Exception e) {
			assertEquals("Estado com nome Acre nao encontrado no banco de dados.", e.getMessage());
		}
	}
	
	@Test
	public void deveDeletarContaPorId() {
		Estado estado = estadoService.criar("Parana");
		Long id = estado.getId();
		estadoService.apagarEstadoPorId(id);
		try {
			estadoService.buscarEstadoPorId(id);
		} catch (Exception e) {
			assertEquals("Estado com id " + id + " nao encontrado no banco de dados.", e.getMessage());
		}
		clean();
	}

}
