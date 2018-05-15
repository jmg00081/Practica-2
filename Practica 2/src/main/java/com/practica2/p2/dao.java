package com.practica2.p2;

import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class dao  implements daoInterface{
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSourve( DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List <dto> leeCoche(){
		String sql= "select * from coches";
		CocheMapper mapper= new CocheMapper();
		List <dto> coches= this.jdbcTemplate.query(sql, mapper);
		return coches;
	}
	
	@Override
	public dto buscaCoche(String matricula, int idparking){
			String sql= "select * from coches where matricula= )";
			Object [] parametros={matricula,idparking};
			CocheMapper mapper = new CocheMapper();
			List <dto> coches = this.jdbcTemplate.query(sql, parametros, mapper);
			if (coches.isEmpty()) return null;
			else return coches.get(0);
		}
	
	
	@Override
	public  void creaCoche(dto coche){
		String sql="insert into values (?,?,?,?)";
		Object [] parametros = {coche.getRegistro(),coche.getIdparking(),coche.getMatricula(), coche.getTimestamp()};
		
		this.jdbcTemplate.update(sql, parametros);
	}
	
	
}
