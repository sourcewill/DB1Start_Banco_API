package com.db1start.cidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidades.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
