<%-- 
    Document   : Login
    Created on : 16/09/2021, 04:40:22 PM
    Author     : Brandon Andree Palma Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/d30c7c2674.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="assets/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Listado Alumnos</title>
    </head>
    <body>
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control Asignación y Clases
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <main class ="pt-4">
            <div class = "container align-items-center col-12 col-md-4">
                <div class="modal-header bg-black text-white d-flex justify-content-center">
                    <h5 class="modal-title text-center" id="exampleModalLabel">LogIn</h5>
                </div>
                <form method="POST" action="${pageContext.request.contextPath}/ServletLoginController" class=" bg-dark container py4 pb-4 rounded  align-content-center was-validated">
                    <div class="mb-3 pt-4">
                        <label for="user"  class="form-label text-white"><i class="fas fa-user"></i>   Usuario:</label>
                        <input type="text" class="form-control" name="user" id="user" required>
                    </div>
                    <div class="mb-3">
                        <label for="pass"  class="form-label text-white"><i class="fas fa-unlock-alt"></i>   Contraseña:</label>
                        <input type="password" class="form-control" name="pass" id="pass" required>
                    </div>
                    <div class="mb-3 d-flex justify-content-center">
                        <label  style="color: red">Usuario o Contraseña incorrecta</label>
                    </div>
                    <input type="hidden" name="accion" value="validar">
                    <div class="modal-footer d-flex justify-content-center">
                        <button type="submit" class="btn btn-danger py-3 rounded-pill"> Iniciar Sesión</button>
                    </div>
                </form>
            </div>
        </main>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="assets/js/jquery-3.6.0.js"></script>
        <script src="assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
