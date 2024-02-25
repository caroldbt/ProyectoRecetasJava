<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>CRUD del usuario</title>
</head>
<body style="display:flex; flex-wrap:wrap; min-height:100vh">

<jsp:include page="cabecera.html"></jsp:include><br>  
	<div class="container mt-5 p-5">
		<div class="card">
			<div class="card-header d-flex justify-content-between bd-highlight mb-3">
				<div class="p-4">
					<button class="btn btn-outline-success" type="button" value="Añadir" onclick="window.location.href='añadir.jsp'"/>
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
					  <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
					  <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
					</svg> &nbsp;Añadir
				</div>
				</button>
				<div class="p-4">
					<c:url var="linkcreador" value="ControladorProductos">
						<c:param name="instruccion" value="creador"></c:param>
					</c:url>
					<a href="${linkcreador}" class="btn btn-outline-danger ">Crear Receta&nbsp;&nbsp;
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
					  <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z"/>
					</svg>
					</a>
					<a href="filtros.jsp" class="btn btn-outline-danger ">Buscador&nbsp;&nbsp;
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
					</a>
				</div>
			</div>
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">Codigo</th>
							<th class="text-center">Producto</th>
							<th class="text-center">Unidades</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempro" items="${lista}">
						<!-- Link para actualizar -->
						<c:url var="linkupdate" value="ControladorProductos">
							<c:param name="instruccion" value="cargar"></c:param>
							<c:param name="articulo" value="${tempro.codigo}"></c:param>
						</c:url>
						<!-- Link para eliminar -->
						<c:url var="linkdelete" value="ControladorProductos">
							<c:param name="instruccion" value="eliminar"></c:param>
							<c:param name="articulo" value="${tempro.codigo}"></c:param>
						</c:url>
							<tr>
								<td class="text-center">${tempro.codigo}</td>
								<td class="text-center">${tempro.producto}</td>
								<td class="text-center">${tempro.unidad}</td> 
								<td class="text-center"><a href="${linkupdate}" class="btn btn-outline-dark "><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
								  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
								  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
								</svg>&nbsp;Update</a></td>
								<td><a href="${linkdelete}" class="btn btn-outline-danger "><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
								  <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
								</svg>&nbsp;Delete</a></td> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>