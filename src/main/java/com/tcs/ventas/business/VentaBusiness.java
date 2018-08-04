package com.tcs.ventas.business;

import java.math.BigDecimal;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Venta;
import com.tcs.ventas.model.VentaDetalle;
import com.tcs.ventas.repository.ClienteRepository;
import com.tcs.ventas.repository.VentaDetalleRepository;
import com.tcs.ventas.repository.VentaRepository;

@Service
public class VentaBusiness {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VentaDetalleRepository ventaDetalleRepository;
	@Autowired
	private VentaRepository ventaRepository;

	public List<Venta> getAll() {
		//List<Venta> venta = new ArrayList<>();

//		List<VentaDetalle> ventaDetalle = ventaDetalleRepository.getAll();
//		for (int j = 0; j < ventaDetalle.size(); j++) {
//			venta.add(getById(j + 1));
//		}
		 return ventaRepository.getAll();
		//return venta;
	}

	public Venta getById(int codigoVenta) {

		Venta venta = new Venta();
		BigDecimal costounit = BigDecimal.ZERO;
		BigDecimal totalCost = BigDecimal.ZERO;

		List<VentaDetalle> ventaDetalle = ventaDetalleRepository.getById(codigoVenta);

		for (VentaDetalle det : ventaDetalle) {
			costounit = det.getCantidad().multiply(det.getImporteProducto());
			totalCost = totalCost.add(costounit);
			det.setSubTotal(costounit);
		}
		venta.setCodigo(codigoVenta);
		venta.setImporteTotal(totalCost);
		venta.setCliente(clienteRepository.getClienteByCodigoVenta(codigoVenta));
		venta.setDetalle(ventaDetalle);
		// return ventaRepository.getById(codigoVenta);
		return venta;
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
