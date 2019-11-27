package com.db1start.cidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidades.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	Optional<Cidade> findByNome(String nome);

}
