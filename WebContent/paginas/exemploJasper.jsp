<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exemplo Jasper</title>
	</head>
	<body>
	
		<form>
		  <div class="">
		    <label for="usu">Usuario</label>
		    <input type="text" class="" id="usu" placeholder="Digite seu nome">
		  </div>
		  <input class="btn btn-default" type="button" value="Input" onclick="gerarPDF()">
		  <input class="btn btn-default" type="button" value="Input" onclick="gerarExcel()">
		</form>
		
	</body>
	
</html>