package com.db1start.cidades.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaServiceTest {

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	private void clean() {
		agenciaService.limpar();
		cidadeService.limpar();
		estadoService.limpar();
	}

	@Test
	public void deveCriarNovaAgencia() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		Agencia agencia = agenciaService.criar("123", cidade, "123");
		
		assertNotNull(agencia);
		clean();
	}

}
