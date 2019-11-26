package com.db1start.cidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidades.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
