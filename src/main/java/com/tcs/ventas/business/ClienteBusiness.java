package com.tcs.ventas.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Cliente;
import com.tcs.ventas.repository.ClienteRepository;

@Service
public class ClienteBusiness {

	@Autowired
	private ClienteRepository clienteRepository;

	
	public List<Cliente> getAll() {
		return clienteRepository.getAll();
	}

	public Cliente getById(int codigoCliente) {
		return clienteRepository.getById(codigoCliente);
	}

	public int save(Cliente cliente) {
		return clienteRepository.insert(cliente);
	}

	public int update(Cliente cliente) {
		return clienteRepository.update(cliente);
	}

	public int remove(int codigoCliente) {
		return clienteRepository.delete(codigoCliente);
	}

}

