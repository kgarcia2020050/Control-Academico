<%-- 
    Document   : Classroom
    Created on : 30/08/2021, 07:52:56 PM
    Author     : Kenneth Gerardo García Lemus
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://kit.fontawesome.com/dc1d5238ef.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="../../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/style.css">

        <script src="../../assets/js/jquery-3.6.0.js"></script>
        <script src="../../assets/js/bootstrap.bundle.js"></script>
        <title>Salones</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control Salones
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <main>
            <section id = "salones">
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
                                    <form method="POST" action="${pageContext.request.contextPath}/ServletSalonController" class="was-validated">
                                        <div class="modal-body">

                                            <div class="mb-3">
                                                <label for="capacidad" class="form-label">Cantidad máxima de alumnos</label>
                                                <input type="number" class="form-control" name="capacidad" id="capacidad" required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="descripcion" class="form-label">Descripción del salón</label>
                                                <input type="text" class="form-control" name="descripcion" id="descripcion" required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="nombreSalon" class="form-label">Nombre del salón</label>
                                                <input type="text" class="form-control" name="nombreSalon" id="nombreSalon" required>
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
                                    <h4><i class="fas fa-chalkboard"></i>    Salones</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover">
                                <thead class="table-dark table-hover">
                                    <tr>
                                        <th>ID</th>
                                        <th>Capacidad</th>
                                        <th>Descripción</th>
                                        <th>Nombre del salón</th>
                                        <th> </th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="salon" items ="${listadoSalones}">
                                        <tr>
                                            <td>${salon.salonId}</td>
                                            <td>${salon.capacidad}</td>
                                            <td>${salon.descripcion}</td>
                                            <td>${salon.nombreSalon}</td>
                                            <td>
                                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletSalonController?accion=editar&salonId=${salon.salonId}">
                                                    <i class="far fa-edit"></i> Editar
                                                </a>
                                            </td>
                                            <td>
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletSalonController?accion=eliminar&salonId=${salon.salonId}"> <i class="fas fa-trash"></i> Eliminar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
                </body>
                </html>
