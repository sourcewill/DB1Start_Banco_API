package com.db1start.cidades.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 60)
	private String nome;

	@OneToMany(mappedBy = "uf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cidade> cidades;

	public Estado(String nome) {
		this.nome = nome;
		this.cidades = new ArrayList<>();
	}

	public Estado() {

	}

	public String getNome() {
		return nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public Long getId() {
		return id;
	}

}
