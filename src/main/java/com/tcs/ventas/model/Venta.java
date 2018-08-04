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
	//private int codigo;
	//private int codigo_cliente;
	
    private List<Producto> producto;
    private BigDecimal cantidad;//en la bd está como decimal luego lo cambio la bd a entero
    private BigDecimal cubTotal;
}
