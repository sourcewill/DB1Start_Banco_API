package com.db1start.cidades.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 60)
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	public Cliente(String nome, String cpf) {

		if (nome == null) {
			throw new RuntimeException("nome nao pode ser nulo");
		}
		if (cpf == null) {
			throw new RuntimeException("cpf nao pode ser nulo");
		}

		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente() {

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
