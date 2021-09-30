<%-- 
    Document   : editar_nota
    Created on : 27/09/2021, 03:08:03 PM
    Author     : Kenneth Gerardo García Lemus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>Editar Notas</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Editar Calificaciones
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <div class="container pb-4 py-4">
            <h4><a  href="${pageContext.request.contextPath}/ServletNotaController?accion=listar" ><i class="fas fa-undo-alt"></i>   Regresar</a></h4>          
        </div>
        <div class="container modal-header bg-dark text-white">
            <h5 class="modal-title" id="exampleModalLabel">Notas</h5>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/ServletNotaController" class=" bg-white container py4 pb-4 was-validated rounded">

            <div class="mb-3">
                <label for="nombreActividad" class="form-label">Actividad</label>
                <input type="text" class="form-control" name="nombreActividad" id="nombreActividad" value="${notas.nombreActividad}" required>
            </div>

            <div class="mb-3">
                <label for="notaActividad" class="form-label">Nota</label>
                <input type="number" class="form-control" name="notaActividad" id="notaActividad" value="${notas.notaActividad}" required>
            </div>

            <div class="mb-3">
                <label for="fechaEntrega" class="form-label">Fecha de entrega</label>
                <input type="date" class="form-control" name="fechaEntrega" id="fechaEntrega" value="${notas.fechaEntrega}" required>
            </div>


            <div class="form-group">
                <label for="asignacionId" class="form-label">ID Asignación</label>
                <select class="form-control" name="asignacionId" id="asignacionId">
                    <c:forEach var="asigns" items="${listadoAsignacion}">
                        <tr>
                        <option>${asigns.asignacionId}</option>
                        </tr>
                    </c:forEach>
                    <option selected>${notas.asignacionId}</option>
                </select>
            </div>

            <input type="hidden" name="idNota" value="${notas.idNota}">
            <input type="hidden" name="accion" value="actualizar">

            <div class="modal-footer">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletNotaController?accion=eliminar&idNota=${notas.idNota}"> <i class="fas fa-trash"></i> Eliminar</a>
                <button type="submit" class="btn btn-success"><i class="far fa-save"></i>   Guardar</button>
            </div>
        </form>
        <div>
            <br>
            <br>
            <br>
        </div>

        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
    </body>

</html>
