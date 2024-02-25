<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<section class="vh-100">
        <div class="container py-5 h-100">
            <div class="row d-flex align-items-center justify-content-center h-100">
                <div class="col-md-8 col-lg-7 col-xl-6">
                    <img src="https://mdbootstrap.com/img/Photos/new-templates/bootstrap-login-form/draw2.svg" class="img-fluid" alt="Phone image">
                </div>
                <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                    <form method="post" action="LoginServlet">
                        <div class="divider d-flex align-items-center my-4">
                        </div>
                        <div class="divider d-flex align-items-center my-4 ">
                            <span>DATOS DE ACCESO:</span>
                        </div>
                        <p class="fs-6 fw-lighter">Todos los campos marcados con * son obligatorios</p>
                        <fieldset>
                            <!-- Usuario input -->
                            <div class="form-outline mb-3">
                                <label class="form-label" for="nombre">USUARIO</label><sup>*</sup>
                                <input type="text" id="nombre" name='usu' class="form-control form-control-lg" required placeholder="Indique el usuario" value=''/>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-3">
                                <label class="form-label" for="contrasena">CONTRASEÑA</label><sup>*</sup>
                                <input type="password" id="contrasena" name='pass' class="form-control form-control-lg" required placeholder="Indique la Contraseña" value=''/>
                            </div>
                            <div>
                            <%-- Mostrar mensaje de error si existe --%>
						    <c:if test="${not empty respuesta}">
						        <p style="color:red;">${respuesta}</p>
						    </c:if>
                            </div>
                        </fieldset>
                        <!-- Submit button -->
                        <div class="d-flex justify-content-between">
                            
                       		<button type="submit" class="btn btn-outline-danger col-6" name='login'>ACCEDER</button>

						    <script src="https://accounts.google.com/gsi/client" async defer></script>

						<div id="g_id_onload"
						     data-client_id="558787499677-2hr2f9lv8os3l1aekn2c0e0pimtbn2bp.apps.googleusercontent.com"
						     data-context="signin"
						     data-ux_mode="redirect"
						     data-login_uri="http://localhost:8080/ProyectoRecetas/inicio.jsp"
						     data-auto_prompt="false">
						</div>
						
						<div class="g_id_signin"
						     data-type="standard"
						     data-shape="rectangular"
						     data-theme="filled_black"
						     data-text="signin_with"
						     data-size="large"
						     data-logo_alignment="left">
						</div>
							
                            
                         </div>
                    </form>
                </div>
            </div>
        </div>
      </section>
</body>
</html>