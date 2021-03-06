package com.tcs.ventas.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

	private int codigo;
	private BigDecimal importeTotal;
	private Cliente cliente;
	private List<VentaDetalle> detalle;

}
