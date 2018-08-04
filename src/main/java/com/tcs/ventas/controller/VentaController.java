package com.tcs.ventas.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.business.ProductoBusiness;
import com.tcs.ventas.model.Producto;
import com.tcs.ventas.model.Venta;

@RestController
public class VentaController {

	@Autowired
	private ProductoBusiness productoBusiness;

	@GetMapping("/venta")
	public List<Venta> getAll() {
		List<Venta> ventas;

		ventas = new ArrayList<>();
		List<Producto> productosventa1 = new ArrayList<>();
		productosventa1.add(productoBusiness.getById(1));
		productosventa1.add(productoBusiness.getById(2));
		Venta venta1 = new Venta(1, 1, new BigDecimal(12.3), productosventa1);
		List<Producto> productosventa2 = new ArrayList<>();
		productosventa2.add(productoBusiness.getById(3));
		Venta venta2 = new Venta(2, 2, new BigDecimal(30.3), productosventa2);
		// Venta venta3 = new Venta(3, 3, new BigDecimal(42.8));

		ventas.add(venta1);
		ventas.add(venta2);
		// ventas.add(venta3);
		return ventas;
	}
}
