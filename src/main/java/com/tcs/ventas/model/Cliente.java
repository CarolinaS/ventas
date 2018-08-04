package com.tcs.ventas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	private int codigo;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
}
