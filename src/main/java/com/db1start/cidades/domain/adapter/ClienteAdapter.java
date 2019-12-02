package com.db1start.cidades.domain.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidades.domain.dto.ClienteDTO;
import com.db1start.cidades.domain.entity.Cliente;

public class ClienteAdapter {

	public static ClienteDTO clienteParaDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		return clienteDTO;
	}

	public static List<ClienteDTO> listaDeClienteParaDTO(List<Cliente> clientes) {
		List<ClienteDTO> listaDeClientesDTO = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ClienteDTO cclienteDTO = clienteParaDTO(cliente);
			listaDeClientesDTO.add(cclienteDTO);
		}
		return listaDeClientesDTO;
	}

}
