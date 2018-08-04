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

import com.tcs.ventas.business.VentaDetalleBusiness;
import com.tcs.ventas.model.VentaDetalle;

@RestController
public class VentaDetalleController {

	@Autowired
	private VentaDetalleBusiness ventaDetalleBusiness;

	@GetMapping("/venta")
	public List<VentaDetalle> getAll() {
		return ventaDetalleBusiness.getAll();
	}

	@GetMapping("/venta/{codigoVenta}")
	public VentaDetalle getById(@PathVariable int codigoVenta) {
		return ventaDetalleBusiness.getById(codigoVenta);
	}

	@PutMapping("/venta")
	public VentaDetalle update(@RequestBody VentaDetalle ventaDetalle) {
		ventaDetalleBusiness.update(ventaDetalle);
		return ventaDetalle;
	}

	@PostMapping("/venta")
	public VentaDetalle save(@RequestBody VentaDetalle ventaDetalle) {
		int codigoVentaDetalle = ventaDetalleBusiness.save(ventaDetalle);
		ventaDetalle.setCodigoVenta(codigoVentaDetalle);
		return ventaDetalle;
	}

	@DeleteMapping("/venta/{id}")
	public VentaDetalle delete(@PathVariable("codigoVenta") int codigoVentaDetalle) {
		VentaDetalle ventaDetalleEliminar = ventaDetalleBusiness.getById(codigoVentaDetalle);
		ventaDetalleBusiness.remove(codigoVentaDetalle);
		return ventaDetalleEliminar;
	}
}
