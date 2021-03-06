package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Cliente;
import com.tcs.ventas.model.Venta;
//import com.tcs.ventas.model.VentaDetalle;


@Repository
public class VentaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//private VentaDetalleRepository ventaDetalleRepository;

	public List<Venta> getAll() {
		String sql = "SELECT v.c_codigo_venta,v.c_total , v.c_codigo_cliente, c.c_nombre_cliente, c.c_apellido_paterno_cliente , c.c_apellido_materno_cliente FROM  t_venta v ,t_cliente c , t_venta_detalle d where v.c_codigo_cliente=c.c_codigo_cliente and v.c_codigo_venta=d.c_codigo_venta";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
            
			Venta venta = new Venta();
			venta.setCodigo(rs.getInt("c_codigo_venta"));
			venta.setImporteTotal(rs.getBigDecimal("c_total"));
			Cliente cli = new Cliente();
			cli.setCodigo(rs.getInt("c_codigo_cliente"));
			cli.setNombres(rs.getString("c_nombre_cliente"));
			cli.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cli.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));
			venta.setCliente(cli);
			
		    
//		List<VentaDetalle> ventaDetalle = ventaDetalleRepository.getById(rs.getInt("c_codigo_venta"));
//		venta.setDetalle(ventaDetalle);
//			// importeTotal = ventaRepository.getImporteTotal(idVenta);
//
//			 VentaDetalleRepository det = new VentaDetalleRepository();
//			 
//             venta.setDetalle(det.getById(rs.getInt("c_codigo_venta")));
			return venta;
		});
	}

	public List<Venta> getById(int codigoVenta) {
		String sql = "SELECT v.c_codigo_venta,v.c_total , v.c_codigo_cliente, c.c_nombre_cliente, c.c_apellido_paterno_cliente , c.c_apellido_materno_cliente FROM t_cliente c , t_venta , t_venta_detalle d  v where  v.c_codigo_cliente=c.c_codigo_cliente and v.c_codigo_venta=d.c_codigo_venta and v.c_codigo_venta = ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			Venta venta = new Venta();
			venta.setCodigo(rs.getInt("c_codigo_venta"));
			// venta.setImporteTotal(rs.getBigDecimal("c_total"));
			Cliente cli = new Cliente();
			cli.setCodigo(rs.getInt("c_codigo_cliente"));
			cli.setNombres(rs.getString("c_nombre_cliente"));
			cli.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cli.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));
			venta.setCliente(cli);
			// importeTotal = ventaRepository.getImporteTotal(idVenta);

			// VentaDetalleRepository det = new VentaDetalleRepository();
			// venta.setDetalle((List<VentaDetalle>)VentaDetalleRepository
			// det.getById(rs.getInt("c_codigo_venta")));;

			return venta;
		}, codigoVenta);
	}

}
