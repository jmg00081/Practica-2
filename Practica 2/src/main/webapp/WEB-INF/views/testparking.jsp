<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	</script>
</head>
<body>

<form action="#" id="enviar">
   <h2> Simulaci�n de los datos de barrera y matricula: </h2>
   Parking Id: <input type="text" name="idparking" id="idparking"> 
   Matricula: <input type="text" name="matricula" id="matricula">
   <br><br>
   <input type="submit" value="Envia Datos"> 
</form>
<script type="text/javascript">
	$('#enviar').submit(function(evento){
		var urlrest = 'coche/crear';
		$.ajax({
			url: urlrest,
			type: 'POST',
			contentType: "application/json",
		    data: JSON.stringify({parkingId:$('#idparking').val(),matricula:$('#matricula').val()}),
		    success: function(){alert('Los datos se han recibido con �xito');},
		    error: function(){alert('Error en el env�o de los datos');}
		});
		evento.preventDefault(); //Evita que se ejecute la petici�n GET del form
	})
</script>

</body>
</html>
