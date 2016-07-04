<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Exemplo Jasper</title>
	</head>
	<body>
	
		<form action="../GerarPDF">
		  <div class="">
		    <label for="nome">nome</label>
		    <input type="text" class="" name="nome" id="nome" placeholder="Digite seu nome">
		  </div>
<!-- 		  <input class="btn btn-default" type="button" value="PDF" onclick="geraRelatorio('GerarPDF')">
		  <input class="btn btn-default" type="button" value="EXCEL" onclick="geraRelatorio('GerarExcel')"> -->
		  
		  <input class="btn btn-default" type="submit" value="pdf">
		</form>
		
		
		<form action="../GerarExcel">
		  <div class="">
		    <label for="nome">nome</label>
		    <input type="text" class="" name="nome" id="nome" placeholder="Digite seu nome">
		  </div>
<!-- 		  <input class="btn btn-default" type="button" value="PDF" onclick="geraRelatorio('GerarPDF')">
		  <input class="btn btn-default" type="button" value="EXCEL" onclick="geraRelatorio('GerarExcel')"> -->
		  
		  <input class="btn btn-default" type="submit" value="exceç">
		</form>
		
	</body>
	
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jasper.js"></script>
</html>