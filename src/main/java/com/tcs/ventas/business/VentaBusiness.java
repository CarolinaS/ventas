package com.tcs.ventas.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Venta;
import com.tcs.ventas.repository.VentaRepository;

@Service
public class VentaBusiness {

	@Autowired
	private VentaRepository ventaRepository;

	public List<Venta> getAll() {
		return ventaRepository.getAll();
	}

	public Venta getById(int codigoVenta) {
		return ventaRepository.getById(codigoVenta);
	}

//	public int save(Venta venta) {
//		return ventaRepository.insert(venta);
//	}
//
//	public int update(Venta venta) {
//		return ventaRepository.update(venta);
//	}
//
//	public int remove(int codigoVenta) {
//		return ventaRepository.delete(codigoVenta);
//	}

}

