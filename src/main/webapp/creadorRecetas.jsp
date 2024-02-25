<%@page import="model.ModeloProductos"%>
<%@page import="controlador.Consulta"%>
<%@page import="model.Productos2"%>
<%@page import="java.util.List"%>
 <%@ page import="java.util.*, controlador.*, model.*" %>
    <%
	
	String product=(String) request.getAttribute("lista2");
    String titulo=Consulta.devolverNombre(product);
   	String[] recetas= Consulta.getRecipes2(titulo);
	%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="ISO-8859-1">
<title>Creador de recetas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body style="display:flex; flex-wrap:wrap; min-height:100vh">
<jsp:include page="cabecera.html"></jsp:include>
	<div class="mt-5 mb-0">
		<button class="btn btn-outline-success" type="button"  onclick="window.location.href='ControladorProductos'">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
 			<path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
		</svg>&nbsp; &nbsp;Volver</button>
	</div>
	 <div id="container">
         <div class="row m-4">
         <% for (String recipe : recetas) { %>
   			<%= recipe %>
          <% }%>
         </div>
     </div>
	<jsp:include page="footer.html"></jsp:include>   
</body>
</html>