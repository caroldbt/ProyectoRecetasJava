<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panel principal</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://apis.google.com/js/platform.js" async defer></script>

<meta name="google-signin-client_id" content="558787499677-2hr2f9lv8os3l1aekn2c0e0pimtbn2bp.apps.googleusercontent.com">
</head>
<body style="display:flex; flex-wrap:wrap; min-height:100vh">
<jsp:include page="cabecera.html"></jsp:include><br>  

<section class="container my-5">
    <div class="w-150 h-200 my-5">
        <div class="d-flex justify-content-center" >
         <a href="ControladorProductos"data-toggle="tooltip" title="Pulsa aqui para comenzar">
			<img src="./logo/Recetas.png"  alt="logo recetas" >
		 </a>   
        </div>
    </div>
</section>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>