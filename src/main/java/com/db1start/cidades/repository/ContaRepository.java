package com.db1start.cidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidades.domain.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	Optional<Conta> findById(Long id);
}
