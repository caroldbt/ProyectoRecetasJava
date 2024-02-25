<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height:100%">
<head>
<meta charset="ISO-8859-1">
<title>Buscador con filtros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body style="display:flex; flex-wrap:wrap; min-height:100vh">
<jsp:include page="cabecera.html"></jsp:include><br> 
	 <div class="container mt-4 p-5">
	 <div class="p-4"></div>
          <form method="post" action="procesarDatos">
              <div class="card">
                  <div class="card-body bd-highlight">
                  	<div class="p-4">
                   		<table class="table table-hover">
							<thead>
								<tr>
									<th class="text-center">Buscar</th>
									<th class="text-center">Tipo de Cocina</th>
									<th class="text-center">Tipo de Dieta</th>
									<th class="text-center">Intolerancia</th>
									<th class="text-center">Ordenar</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input class="form-control me-2" type="text" placeholder="Search for name" aria-label="Search" name="search">
				                    </td>
									<td><select name="tipoCocina" class="boton form-select form-select-sm" onchange="this.form['valor'].value=this.value" aria-label="form-select-sm " >
			                            <option name="tipoCocina" selected></option>
			                            <option name="tipoCocina" value="Asian">Asiático</option>
			                            <option name="tipoCocina" value="French">Francés</option>
			                            <option name="tipoCocina" value="Italian">Italiano</option>
			                            <option name="tipoCocina" value="Mediterranean">Mediterraneano</option>
			                        </select></td>
									<td><select name="tipoDieta" class="form-select form-select-sm" aria-label="form-select-sm " >
			                            <option name="tipoDieta" selected></option>
			                            <option name="tipoDieta" value="Gluten free">Sin gluten</option>
			                            <option name="tipoDieta" value="Vegetarian">Vegetariano</option>
			                            <option name="tipoDieta" value="Lacto-Vegetarian">Lacto-Vegetariano</option>
			                            <option name="tipoDieta" value="Ovo-Vegetarian">Vegano</option>
			                        </select></td>
								
									<td><select name="intolerancia" class="form-select form-select-sm" aria-label="form-select-sm " >
			                            <option name="intolerancia" selected></option>
			                            <option name="intolerancia" value="Gluten">Gluten</option>
			                            <option name="intolerancia" value="Dairy">Lácteos</option>
			                            <option name="intolerancia" value="Egg">Huevo</option>
			                            <option name="intolerancia" value="Grain">Grano</option>
			                            <option name="intolerancia" value="Peanut">Cacahuete</option>
			                            <option name="intolerancia" value="Sesame">Sésamo</option>
			                            <option name="intolerancia" value="Seafood">Mariscos</option>
			                            <option name="intolerancia" value="Wheat">Trigo</option>
			                        </select></td>
								
									<td><select name="ordenar" class="form-select form-select-sm" aria-label="form-select-sm " >
			                            <option name="ordenar" selected></option>
			                            <option name="ordenar" value="time">tiempo</option>
			                            <option name="ordenar" value="calories">calorias</option>
			                            <option name="ordenar" value="protein">proteinas</option>
			                            <option name="ordenar" value="cholesterol">colesterol</option>
			                            <option name="ordenar" value="sugar">sugar</option>
			                        </select></td>
			                        <td><button type="submit" class="btn btn-outline-success" >Aplicar</button>
                            		</td>
								</tr>
							</tbody>
						</table>
                  	</div>
                  </div>
               </div>
           </form>
		</div>
		
		<% String dato= (String) request.getAttribute("container");
           String dato2= (String) request.getAttribute("container2");
           String dato3= (String) request.getAttribute("container3");
           String dato4= (String) request.getAttribute("container4");
           String dato5= (String) request.getAttribute("container5");
           if(dato == "" &&  dato2=="" &&  dato3=="" &&  dato4=="" &&  dato5==""){ %>
           <div class="container">
               
                <div class="row m-4"> 
                <%String[] recetas2= controlador.Consulta.getRecipes3("", "", "", "", "");
                for (String recipe : recetas2) { %>
		        <%= recipe %>
                 <% }%> 
                </div>
            </div>
            <%}else if(dato != null ||  dato2!= null ||  dato3!= null ||  dato4!= null ||  dato5!= null){
           String[] recetas= controlador.Consulta.getRecipes3(dato, dato2, dato3, dato4, dato5);//View.Consulta.getRecipes2(dato,dato2,dato3,dato4, dato5);%>
           <div id="container">
                <div class="row m-4">
                <% for (String recipe : recetas) { %>
		        <%= recipe %>
                 <% }
            	}else{%>
            	</div>
            </div>
           	<div class="container">
                <div class="row m-4"> 
                <%String[] recetas1= controlador.Consulta.getRecipes3("", "","","","");
                for (String recipe : recetas1) { %>
		        <%= recipe %>
                 <% }%> 
                </div>
        	</div>
            
           <% }%>
                
            
        <jsp:include page="footer.html"></jsp:include>
</body>
</html>