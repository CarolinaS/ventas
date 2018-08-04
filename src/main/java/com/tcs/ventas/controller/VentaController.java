package com.tcs.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.business.VentaBusiness;
import com.tcs.ventas.model.Venta;

@RestController
public class VentaController {

	
//	@GetMapping("/ventas")
//	public List<Venta> getAll() {
//		List<Venta> ventas;
//
//		ventas = new ArrayList<>();
//		List<Producto> productosventa1 = new ArrayList<>();
//		productosventa1.add(productoBusiness.getById(1));
//		productosventa1.add(productoBusiness.getById(2));
//		Venta venta1 = new Venta(productosventa1, new BigDecimal(12.0), new BigDecimal(78.9));
//		List<Producto> productosventa2 = new ArrayList<>();
//		productosventa2.add(productoBusiness.getById(3));
//		Venta venta2 = new Venta(productosventa2, new BigDecimal(6.0), new BigDecimal(97.6));
//		// Venta venta3 = new Venta(3, 3, new BigDecimal(42.8));
//
//		ventas.add(venta1);
//		ventas.add(venta2);
//		// ventas.add(venta3);
//		return ventas;
//	}
	
	@Autowired
	private VentaBusiness ventaBusiness;

	@GetMapping("/venta/detalle")
	public List<Venta> getAll() {
		return ventaBusiness.getAll();
	}

	@GetMapping("/venta/detalle/{codigoVenta}")
	public Venta getById(@PathVariable int codigoVenta) {
		return ventaBusiness.getById(codigoVenta);
	}

//	@PutMapping("/venta/detalle")
//	public Venta update(@RequestBody Venta venta) {
//		ventaBusiness.update(venta);
//		return venta;
//	}
//
//	@PostMapping("/venta/detalle")
//	public Venta save(@RequestBody Venta venta) {
//		int codigoVenta = ventaBusiness.save(venta);
//		venta.setCodigo(codigoVenta);
//		return venta;
//	}
//
//	@DeleteMapping("/venta/detalle/{id}")
//	public Venta delete(@PathVariable("id") int codigoVenta) {
//		Venta ventaEliminar = ventaBusiness.getById(codigoVenta);
//		ventaBusiness.remove(codigoVenta);
//		return ventaEliminar;
//	}
	
	
	
	
	
}
