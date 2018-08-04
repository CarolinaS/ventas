package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Cliente;

@Repository
public class ClienteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cliente> getAll() {
		String sql = "SELECT c_codigo_cliente, c_nombre_cliente, c_apellido_paterno_cliente , c_apellido_materno_cliente FROM t_cliente";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Cliente cliente = new Cliente();
			cliente.setCodigo(rs.getInt("c_codigo_cliente"));
			cliente.setNombres(rs.getString("c_nombre_cliente"));
			cliente.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cliente.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));
			
			
			return cliente;
		});
	}

	public Cliente getById(int codigoCliente) {
		String sql = "SELECT c_codigo_cliente, c_nombre_cliente, c_apellido_paterno_cliente , c_apellido_materno_cliente FROM t_cliente"
				+ " WHERE c_codigo_cliente = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Cliente cliente = new Cliente();
			cliente.setCodigo(rs.getInt("c_codigo_cliente"));
			cliente.setNombres(rs.getString("c_nombre_cliente"));
			cliente.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cliente.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));
			return cliente;
		}, codigoCliente);
	}

	private int getNextId() {
		String sql = "SELECT MAX(c_codigo_cliente) + 1 FROM t_cliente";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	public int insert(Cliente cliente) {
		String sql = "INSERT INTO t_cliente (c_codigo_cliente, c_nombre_cliente, c_apellido_paterno_cliente , c_apellido_materno_cliente)"
				+ " VALUES (?, ?, ? , ?)";
		int newId = getNextId();
		System.out.println(newId);
		jdbcTemplate.update(sql, newId, cliente.getNombres(), cliente.getApellidoPaterno(),cliente.getApellidoMaterno());
		return newId;
	}

	public int update(Cliente cliente) {
		String sql = "UPDATE t_cliente SET" + " c_nombre_cliente = ?," + "c_apellido_paterno_cliente = ?," + "c_apellido_materno_cliente = ?"
				+ " WHERE c_codigo_cliente = ?";
		return jdbcTemplate.update(sql, cliente.getNombres(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno());
	}

	public int delete(int codigoCliente) {
		String sql = "DELETE FROM t_cliente WHERE c_codigo_cliente = ?";
		return jdbcTemplate.update(sql, codigoCliente);
	}

}
