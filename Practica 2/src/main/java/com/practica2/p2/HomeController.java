package com.practica2.p2;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	daoInterface dao;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		
		return "testparking";
	}

	@RequestMapping (value= "/coste/{matricula}", method= RequestMethod.GET)
	public @ResponseBody String coste (@PathVariable (value="matricula") String matricula, Model model){
		double precio;
		double tarifa=0.005;
		Timestamp entrada=dao.buscaCoche(matricula,0).getTimestamp();
		Timestamp salida=dao.buscaCoche(matricula, 1).getTimestamp();
		
		double tiempo=entrada.getTime()-salida.getTime();
		precio=tiempo*tarifa;
		
		String coste=Double.toString(precio);
	return coste;
	}
	
	
	@RequestMapping (value="/coche/crear", method = RequestMethod.POST)
	public ResponseEntity<dto> creacoche(@RequestBody dto coche){
		dao.creaCoche(coche);
		HttpHeaders cabeceras =new HttpHeaders();
		try{
			cabeceras.setLocation(new URI ("http://localhost:8080/rest/coche/"+coche.getMatricula()+coche.getIdparking()));
		} catch (URISyntaxException e) {e.printStackTrace();}
		ResponseEntity<dto> respuestaHTTP = new ResponseEntity<dto> (coche,cabeceras,HttpStatus.CREATED);
	
		return respuestaHTTP;
	}

	
	
}
