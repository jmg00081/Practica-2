package com.practica2.p2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class dto implements Serializable{
	private String registro;
	private int idparking;
	private String matricula;
	private Timestamp timestamp;
	
	public dto(){
		super();
	}
	
	public dto(String registro, int idparking, String matricula, Timestamp timestamp) {
		
		this.registro=registro;
		this.idparking=idparking;
		this.matricula=matricula;
		this.timestamp=timestamp;

	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public int getIdparking() {
		return idparking;
	}

	public void setIdparking(int idparking) {
		this.idparking = idparking;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
}

