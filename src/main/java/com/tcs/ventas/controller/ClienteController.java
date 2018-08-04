package com.tcs.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.business.ClienteBusiness;
import com.tcs.ventas.model.Cliente;

@RestController
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;

	@GetMapping("/cliente")
	public List<Cliente> getAll() {
		return clienteBusiness.getAll();
	}

	@GetMapping("/cliente/{codigoCliente}")
	public Cliente getById(@PathVariable int codigoCliente) {
		return clienteBusiness.getById(codigoCliente);
	}

	@PutMapping("/cliente")
	public Cliente update(@RequestBody Cliente cliente) {
		clienteBusiness.update(cliente);
		return cliente;
	}

	@PostMapping("/cliente")
	public Cliente save(@RequestBody Cliente cliente) {
		int codigoCliente = clienteBusiness.save(cliente);
		cliente.setCodigo(codigoCliente);
		return cliente;
	}

	@DeleteMapping("/cliente/{id}")
	public Cliente delete(@PathVariable("id") int codigoCliente) {
		Cliente clienteEliminar = clienteBusiness.getById(codigoCliente);
		clienteBusiness.remove(codigoCliente);
		return clienteEliminar;
	}
}
