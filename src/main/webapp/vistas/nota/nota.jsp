<%-- 
    Document   : nota
    Created on : 27/09/2021, 03:07:54 PM
    Author     : Kenneth Gerardo García Lemus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://kit.fontawesome.com/dc1d5238ef.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="../../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/style.css">

        <script src="../../assets/js/jquery-3.6.0.js"></script>
        <script src="../../assets/js/bootstrap.bundle.js"></script>
        <title>Calificaciones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control de calificaciones
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <main>
            <section id = "notas">
                <div class="container mt-5 mb-5 pb-5 ">
                    <div class="row">
                        <div class="col-12 col-md-3">
                            <div class="btn btn-success card text-center bg-success text-white mb-3">
                                <div class="card-body btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    <i class="fas fa-plus"></i> Agregar
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Agregar</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form method="POST" action="${pageContext.request.contextPath}/ServletNotaController" class="was-validated">
                                        <div class="modal-body">

                                            <div class="mb-3">
                                                <label for="nombreActividad" class="form-label">Actividad</label>
                                                <input type="text" class="form-control" name="nombreActividad" id="nombreActividad" required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="notaActividad" class="form-label">Nota</label>
                                                <input type="number" class="form-control" name="notaActividad" id="notaActividad" required>
                                            </div>


                                            <div class="form-group">
                                                <label for="asignacionId" class="form-label">ID Asignación</label>
                                                <select class="form-control" name="asignacionId" id="asignacionId">
                                                    <c:forEach var="asigns" items="${listadoAsignacion}">
                                                        <tr>
                                                        <option>${asigns.asignacionId}</option>
                                                        </tr>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <input type="hidden" name="accion" value="insertar">

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-warning" data-bs-dismiss="modal"><i class="fas fa-times"></i>   Cancelar</button>
                                            <button type="submit" class="btn btn-success"><i class="far fa-save"></i>   Guardar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4><i class="fas fa-chalkboard"></i>    Notas</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover">
                                <thead class="table-dark table-hover">
                                    <tr>
                                        <th>ID</th>
                                        <th>Actividad</th>
                                        <th>Nota</th>
                                        <th>Fecha de entrega</th>
                                        <th>ID Asignación</th>
                                        <th> </th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="notas" items ="${listadoNota}">
                                        <tr>
                                            <td>${notas.idNota}</td>
                                            <td>${notas.nombreActividad}</td>
                                            <td>${notas.notaActividad}</td>
                                            <td>${notas.fechaEntrega}</td>
                                            <td>${notas.asignacionId}</td>
                                            <td>
                                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletNotaController?accion=editar&idNota=${notas.idNota}">
                                                    <i class="far fa-edit"></i> Editar
                                                </a>
                                            </td>
                                            <td>
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletNotaController?accion=eliminar&idNota=${notas.idNota}"> <i class="fas fa-trash"></i> Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="col-12 col-md-3">
                            <div class="card text-center bg-success text-white mb-3">
                                <div class="card-body">
                                    <h3>Actividades aprobadas</h3>
                                    <h4 class="display-4">
                                        ${notasGanadas} <i class="fas fa-check"></i>
                                    </h4>
                                </div>
                            </div>

                            <div class="card text-center bg-danger text-white mb-3">
                                <div class="card-body">
                                    <h3>Actividades reprobadas</h3>
                                    <h4 class="display-4">
                                        ${notasPerdidas} <i class="fas fa-times"></i>
                                    </h4>
                                </div>
                            </div>

                            <div class="card text-center bg-warning text-white mb-3">
                                <div class="card-body">
                                    <h3>Promedio de notas</h3>
                                    <h4 class="display-4">
                                        ${promedioNotas} <i class="fas fa-user-graduate"></i>
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
                </body>

                </html>
