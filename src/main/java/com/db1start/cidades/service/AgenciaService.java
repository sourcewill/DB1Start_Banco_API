package com.db1start.cidades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidades.domain.entity.Agencia;
import com.db1start.cidades.domain.entity.Cidade;
import com.db1start.cidades.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia criar(String numeroAgencia, Cidade cidade, String numeroBanco) {
		Agencia agencia = new Agencia(numeroAgencia, cidade, numeroBanco);
		return agenciaRepository.save(agencia);
	}
	
	public void limpar() {
		agenciaRepository.deleteAll();
	}
	
	public Agencia buscarPorNumeroAgencia(String numeroAgencia) {
		return agenciaRepository.findByNumeroAgencia(numeroAgencia).orElseThrow(
				() -> new RuntimeException("Agencia com numero " + numeroAgencia + " nao encontrada no banco de dados."));
	}
	
	public void apagarAgencia(Long id) {
		agenciaRepository.deleteById(id);
	}
	
	public Agencia buscarPorId(Long id) {
		return agenciaRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Agencia com id " + id + " nao encontrada no banco de dados."));
	}
	
	public List<Agencia> buscarTodas(){
		return agenciaRepository.findAll();
	}
	
	public List<Agencia> buscarTodasAgenciasEmUmaCidade(Cidade cidade){
		List<Agencia> agencias = new ArrayList<>();
		for(Agencia agencia: buscarTodas()) {
			if(agencia.getCidade().equals(cidade)) {
				agencias.add(agencia);
			}
		}
		return agencias;
	}

}
