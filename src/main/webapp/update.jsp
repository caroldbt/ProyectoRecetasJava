<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Update</title>
</head>
<body>
	<jsp:include page="cabecera.html"></jsp:include><br>  
	<div class="m-4">
		<button class="btn btn-outline-success" type="button"  onclick="window.location.href='ControladorProductos'">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
	  <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
		</svg>&nbsp; &nbsp;Volver</button>
	</div>
	<div class="container mt-5">
		<div class="d-flex justify-content-center">
			<div class="d-inline-flex p-2 bd-highlight">
				<form class="row" method="get" action="ControladorProductos">
				<input type="hidden" name="instruccion" value="updateBBDD">
				<input type="hidden" name="codigo" value="${actualiza.codigo}">
				  
				  <div class="mb-2 col-md-6">
				    <label for="producto" class="form-label">Producto</label>
				    <input type="text" value="${actualiza.producto}" name="producto" class="form-control " id="producto">
				  </div>
				  <div class="mb-2 col-md-6">
				    <label for="unidad" class="form-label">Unidades</label>
				    <input type="number" value="${actualiza.unidad}" name="unidad" class="form-control " id="unidad">
				  </div>
				  <div class="d-flex justify-content-between mt-5">
					  <button type="submit" class="btn btn-primary ">Enviar</button>
					  <input type="reset" name="borrar" id="borrar" value="Restablecer">
				  </div>
				</form>
		</div>
	</div>
</body>
</html>