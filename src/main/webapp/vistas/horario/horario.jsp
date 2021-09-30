<%-- 
    Document   : horario
    Created on : 31/08/2021, 04:56:56 PM
    Author     : Brandon Andree Palma Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/d30c7c2674.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/style.css">
        <title>Listado Horarios</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control Horarios
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <main>
            <section id = "horario">
                <div class="container mt-5 mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 col-md-3">
                            <div class="btn btn-success card text-center bg-success text-white mb-3">
                                <div class="card-body btn btn-success" data-bs-toggle="modal" data-bs-target="#addModal">
                                    <i class="fas fa-plus"></i> Agregar
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header bg-dark text-white">
                                        <h5 class="modal-title" id="exampleModalLabel">Agregar Horario</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form method="POST" action="${pageContext.request.contextPath}/ServletHorarioController" class ="was-validated">
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                <label for="horaInicio" class="form-label">Hora Entrada</label>
                                                <input type="time" class="form-control" name="horaInicio" id="horaInicio" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="horaFinal"  class="form-label">Hora Salida</label>
                                                <input type="time" class="form-control" name="horaFinal" id="horaFinal" required>
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
                                    <h4><i class="fas fa-calendar-alt"></i>        Horarios</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover"">
                                <thead class="table-dark table-hover">
                                    <tr>
                                        <th>ID</th>
                                        <th>Horario Inicio</th>
                                        <th>Horario Final</th>
                                        <th>    </th>
                                        <th>    </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="horario" items="${listadoHorario}">
                                        <tr>
                                            <td>${horario.idHorario}</td>
                                            <td>${horario.horaInicio}</td>
                                            <td>${horario.horaFinal}</td>
                                            <td><a class = "btn btn-warning" href="${pageContext.request.contextPath}/ServletHorarioController?accion=editar&idHorario=${horario.idHorario}"><i class="far fa-edit"></i>    Editar</a></td>
                                            <td><a class = "btn btn-danger"  href="${pageContext.request.contextPath}/ServletHorarioController?accion=eliminar&idHorario=${horario.idHorario}" id="deleteBtn" type="button"><i class="fas fa-trash"></i>    Eliminar</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="../../assets/js/jquery-3.6.0.js"></script>
        <script src="../../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
