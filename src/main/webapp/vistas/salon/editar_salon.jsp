<%-- 
    Document   : editar_salon
    Created on : 13/09/2021, 07:22:20 PM
    Author     : Kenneth Gerardo García Lemus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/style.css">  
        <link rel="stylesheet" href="./assets/css/bootstrap.css">

        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>

        <script src="https://kit.fontawesome.com/dc1d5238ef.js" crossorigin="anonymous"></script>

        <title>Editar salones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Editar Salones
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pb-4 py-4">
            <h4><a  href="${pageContext.request.contextPath}/ServletSalonController?accion=listar" ><i class="fas fa-undo-alt"></i>   Regresar</a></h4>          
        </div>
        <div class="container modal-header bg-dark text-white">
            <h5 class="modal-title" id="exampleModalLabel">Salón</h5>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/ServletSalonController" class=" bg-white container py4 pb-4 was-validated rounded">

            <div class="mb-3 pt-4">
                <label for="capacidad" class="form-label">Cantidad máxima de alumnos</label>
                <input type="number" class="form-control" name="capacidad" id="capacidad" required value="${salon.capacidad}">
            </div>

            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripcion del salón</label>
                <input type="text" class="form-control" name="descripcion" id="descripcion" required value="${salon.descripcion}">
            </div>

            <div class="mb-3">
                <label for="nombreSalon" class="form-label">Nombre del salón</label>
                <input type="text" class="form-control" name="nombreSalon" id="nombreSalon" required value="${salon.nombreSalon}">
            </div>

            <input type="hidden" name="salonId" value="${salon.salonId}">
            <input type="hidden" name="accion" value="actualizar">

            <div class="modal-footer">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletSalonController?accion=eliminar&salonId=${salon.salonId}"> <i class="fas fa-trash"></i> Eliminar</a>
                <button type="submit" class="btn btn-success"><i class="far fa-save"></i>   Guardar</button>
            </div>
        </form>

        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
    </body>

</html>
