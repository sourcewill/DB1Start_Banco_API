package com.db1start.cidades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {
	
	@GetMapping("/estados")
	public String buscarTodosEstados() {
		return "Meus Estados";
	}

}
