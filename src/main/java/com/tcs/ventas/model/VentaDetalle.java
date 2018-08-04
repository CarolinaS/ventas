package com.tcs.ventas.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {
	private int codigoVenta;
	private int idProducto;
	private String nombreProducto;
	private BigDecimal importeProducto;
	private BigDecimal cantidad;// en la bd está como decimal luego lo cambio la bd a entero
	private BigDecimal subTotal;

}
