package com.db1start.cidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidades.domain.entity.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	Optional<Agencia> findByNumeroAgencia(String numeroAgencia);
	
}
