package com.practica2.p2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class CocheMapper implements RowMapper <dto>{
	public dto mapRow(ResultSet rs, int rowNum) throws SQLException{
		dto coche = new dto();
		coche.setRegistro(rs.getString("Registro"));
		coche.setIdparking(rs.getInt("Idparking"));
		coche.setMatricula(rs.getString("Matriculo"));
		coche.setTimestamp(rs.getTimestamp("Timestamp:"));
		return coche;
}
}
