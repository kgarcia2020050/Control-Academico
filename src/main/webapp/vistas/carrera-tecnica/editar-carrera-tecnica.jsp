<%-- 
    Document   : editar-carrera-tecnica
    Created on : 13/09/2021, 06:40:08 PM
    Author     : Juan Diego Solís Martínez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/d30c7c2674.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="././assets/css/bootstrap.css">
        <link rel="stylesheet" href="././assets/css/style.css">
        <title>Editar Carreras Técnicas</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Editar Carreras Técnicas
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pb-4 py-4">
            <h4><a  href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=listar" ><i class="fas fa-undo-alt"></i>   Regresar</a></h4>          
        </div>
        <div class="container modal-header bg-dark text-white">
            <h5 class="modal-title" id="exampleModalLabel">Carrera Técnica</h5>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/ServletCarreraTecnicaController" class=" bg-white container py4 pb-4 was-validated rounded">
            <div class="mb-3 pt-4">
                <label for="nombre"  class="form-label"> Nombre</label>
                <input type="text" class="form-control" name="nombre" id="nombre" required value="${carreraTecnica.nombre}">
            </div>
            <input type="hidden" name="codigoCarrera" value="${carreraTecnica.codigoCarrera}">
            <input type="hidden" name="accion" value="actualizar">
            <div class="modal-footer">
                <a class = "btn btn-danger"  href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=eliminar&codigoCarrera=${carreraTecnica.codigoCarrera}" id="deleteBtn" type="button"><i class="fas fa-trash"></i>    Eliminar</a>
                <button type="submit" class="btn btn-success"><i class="far fa-save"></i>   Guardar</button>
            </div>
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="././assets/js/jquery-3.6.0.js"></script>
        <script src="././assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
