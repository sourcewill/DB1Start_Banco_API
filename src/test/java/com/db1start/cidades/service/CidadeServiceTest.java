package com.db1start.cidades.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeServiceTest {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	private void clean() {
		cidadeService.apagarTodasCidades();
		estadoService.apagarTodosEstados();
	}

	@Test
	public void deveCriarNovaCidade() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		assertNotNull(cidade);
		System.out.println("Cidade: " + cidade.getNome() + " | Estado: " + cidade.getUf().getNome());
		clean();
	}
	
	@Test
	public void deveDeletarCidadePorId() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		Long id = cidade.getId();
		cidadeService.apagarCidadePorId(id);
		try {
			cidadeService.buscarCidadePorId(id);
		} catch (Exception e) {
			assertEquals("Cidade com id " + id + " nao encontrada no banco de dados.", e.getMessage());
		}
		clean();
	}

}
