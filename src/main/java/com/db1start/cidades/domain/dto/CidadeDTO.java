package com.db1start.cidades.domain.dto;

import com.db1start.cidades.domain.entity.Estado;

public class CidadeDTO {

	private Long id;
	private String nome;
	private Estado uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

}
