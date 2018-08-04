package com.tcs.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.VentaDetalle;
import com.tcs.ventas.repository.VentaDetalleRepository;

@Service
public class VentaDetalleBusiness {

	@Autowired
	private VentaDetalleRepository ventaDetalleRepository;

	public List<VentaDetalle> getAll() {
		return ventaDetalleRepository.getAll();
	}

	public List<VentaDetalle> getById(int codigoVenta) {
		return ventaDetalleRepository.getById(codigoVenta);
	}

	public int save(VentaDetalle ventaDetalle) {
		return ventaDetalleRepository.insert(ventaDetalle);
	}

	public int update(VentaDetalle ventaDetalle) {
		return ventaDetalleRepository.update(ventaDetalle);
	}

	public int remove(int codigoVentaDetalle) {
		return ventaDetalleRepository.delete(codigoVentaDetalle);
	}

}
