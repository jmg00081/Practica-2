package com.practica2.p2;

import java.util.List;

public interface daoInterface {

	public List<dto> leeCoche();

	public dto buscaCoche(String matricula, int idparking);

	public void creaCoche(dto coche);

}
