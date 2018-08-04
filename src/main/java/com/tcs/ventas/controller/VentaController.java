package com.tcs.ventas.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.model.Venta;

@RestController
public class VentaController {
	@GetMapping("/venta")
	public List<Venta> getAll() {
		List<Venta> ventas ;
		
	     ventas = new ArrayList<>();

		Venta venta1 = new Venta(1, 1, new BigDecimal(12.3));
		Venta venta2 = new Venta(2, 2, new BigDecimal(30.3));
		Venta venta3 = new Venta(3, 3, new BigDecimal(42.8));
		
		ventas.add(venta1);
		ventas.add(venta2);
		ventas.add(venta3);
		return ventas;
	}
}
