package com.db1start.cidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.domain.entity.Cliente;
import com.db1start.cidades.domain.entity.Conta;
import com.db1start.cidades.domain.entity.Estado;
import com.db1start.cidades.service.AgenciaService;
import com.db1start.cidades.service.CidadeService;
import com.db1start.cidades.service.ClienteService;
import com.db1start.cidades.service.ContaService;
import com.db1start.cidades.service.EstadoService;

@SpringBootApplication
public class CidadesApplication {
	
	@Autowired
	private static AgenciaService agenciaService;

	@Autowired
	private static CidadeService cidadeService;

	@Autowired
	private static EstadoService estadoService;

	@Autowired
	private static ClienteService clienteService;
	
	@Autowired
	private static ContaService contaService;

	public static void main(String[] args) {
		SpringApplication.run(CidadesApplication.class, args);
		System.out.println("Iniciando...");

	}

}
