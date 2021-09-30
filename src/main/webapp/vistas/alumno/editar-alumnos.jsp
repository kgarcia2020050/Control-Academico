<%-- 
    Document   : editar-alumnos
    Created on : 13/09/2021, 06:19:24 PM
    Author     : garci
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/d30c7c2674.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="././assets/css/bootstrap.css">
        <link rel="stylesheet" href="././assets/css/style.css">

        <title>Editar Alumnos</title>
    </head>
    <body>
        <!-- Cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />
        <div id="main-header" class =" py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Editar Alumnos
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pb-4 py-4">
            <h4><a  href="${pageContext.request.contextPath}/ServletAlumnoController?accion=listar" ><i class="fas fa-undo-alt"></i>   Regresar</a></h4>          
        </div>
        <div class="container modal-header bg-dark text-white">
            <h5 class="modal-title" id="exampleModalLabel">Alumno</h5>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/ServletAlumnoController" class=" bg-white container py4 pb-4 was-validated rounded">
            <div class="mb-3 pt-4">
                <label for="nombres" class="form-label">Nombres:</label>
                <input type="text" class="form-control" name="nombres" id="nombres" required  value="${alumno.nombres}">
            </div>
            <div class="mb-3">
                <label for="apellidos" class="form-label">Apellidos:</label>
                <input type="text" class="form-control" name="apellidos" id="apellidos" required  value="${alumno.apellidos}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" name="email" id="email" required  value="${alumno.email}">
            </div>
            <input type="hidden" name="carne" value="${alumno.carne}">
            <input type="hidden" name="accion" value="actualizar">
            <div class="modal-footer">
                <a class = "btn btn-danger"  href="${pageContext.request.contextPath}/ServletAlumnoController?accion=eliminar&carne=${alumno.carne}" id="deleteBtn" type="button"><i class="fas fa-trash"></i>    Eliminar</a>
                <button type="submit" class="btn btn-success"><i class="far fa-save"></i>   Guardar</button>
            </div>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="././assets/js/jquery-3.6.0.js"></script>
        <script src="././assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
