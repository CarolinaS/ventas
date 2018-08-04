package com.tcs.ventas.repository;

//import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.tcs.ventas.model.Producto;
import com.tcs.ventas.model.VentaDetalle;

@Repository
public class VentaDetalleRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<VentaDetalle> getAll() {
		String sql = "SELECT d.c_codigo_venta,p.c_codigo_producto, p.c_nombre_producto, p.c_precio_base , d.c_codigo_producto, d.c_cantidad, d.c_cantidad*p.c_precio_base  FROM t_producto p , t_venta_detalle d where p.c_codigo_producto = d.c_codigo_producto ";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			VentaDetalle detalle = new VentaDetalle();
			detalle.setCodigoVenta(rs.getInt("c_codigo_venta"));
			detalle.setIdProducto(rs.getInt("c_codigo_producto"));
			detalle.setNombreProducto(rs.getString("c_nombre_producto"));
			detalle.setImporteProducto(rs.getBigDecimal("c_precio_base"));
			detalle.setCantidad(rs.getBigDecimal("c_cantidad"));
			detalle.setSubTotal(rs.getBigDecimal("d.c_cantidad*p.c_precio_base"));
			return detalle;
		});
	}

	
	public List<VentaDetalle> getById(int codigoVentaDetalle) {
		String sql = "SELECT d.c_codigo_venta,p.c_codigo_producto, p.c_nombre_producto, p.c_precio_base , d.c_codigo_producto, d.c_cantidad, d.c_cantidad*p.c_precio_base  FROM t_producto p , t_venta_detalle d where p.c_codigo_producto = d.c_codigo_producto and  d.c_codigo_venta = ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			VentaDetalle detalle = new VentaDetalle();
			detalle.setCodigoVenta(rs.getInt("c_codigo_venta"));
			detalle.setIdProducto(rs.getInt("c_codigo_producto"));
			detalle.setNombreProducto(rs.getString("c_nombre_producto"));
			detalle.setImporteProducto(rs.getBigDecimal("c_precio_base"));
			detalle.setCantidad(rs.getBigDecimal("c_cantidad"));
			detalle.setSubTotal(rs.getBigDecimal("d.c_cantidad*p.c_precio_base"));
			return detalle;
		}, codigoVentaDetalle);
	}


	private int getNextId() {
		String sql = "SELECT MAX(c_codigo_venta) + 1 FROM t_venta_detalle";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	public int insert(VentaDetalle ventaDetalle) {
		String sql = "INSERT INTO t_venta_detalle (c_codigo_venta, c_codigo_producto, c_cantidad)"
				+ " VALUES (?, ?, ?)";
		int newId = getNextId();
		 System.out.println(newId);
		jdbcTemplate.update(sql,newId, ventaDetalle.getIdProducto(),
				ventaDetalle.getCantidad());
		return ventaDetalle.getCodigoVenta();
	}

	public int update(VentaDetalle ventaDetalle) {
		String sql = "UPDATE t_venta_detalle SET"  + " c_codigo_producto = ? ,"
				+ " c_cantidad = ?" + " WHERE c_codigo_venta = ?";
		return jdbcTemplate.update(sql, ventaDetalle.getIdProducto(),
				ventaDetalle.getCantidad());
	}

	public int delete(int codigoVentaDetalle) {
		String sql = "DELETE FROM t_venta_detalle WHERE c_codigo_venta = ?";
		return jdbcTemplate.update(sql, codigoVentaDetalle);
	}

}
