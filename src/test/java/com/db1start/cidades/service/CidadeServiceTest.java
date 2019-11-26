package com.db1start.cidades.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Estado;

public class CidadeServiceTest {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	private void clean() {
		cidadeService.limpar();
		estadoService.limpar();
	}

	@Test
	public void deveCriarNovaCidade() {
		Estado estado = estadoService.criar("Parana");
		Cidade cidade = cidadeService.criar("Maringa", estado);
		assertNotNull(cidade);
		System.out.println("Cidade: " + cidade.getNome() + " | Estado: " + cidade.getUf().getNome());
		clean();
	}

}
