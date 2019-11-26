package com.db1start.cidades.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.db1start.cidades.repository.CidadeRepository;

public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;

}
