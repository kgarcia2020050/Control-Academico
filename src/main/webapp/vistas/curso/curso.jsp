<%-- 
    Document   : curso
    Created on : 28/08/2021, 11:57:58 AM
    Author     : Juan Diego Solís Martínez
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
        <title>Listado Cursos</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />
        <div id="main-header" class ="py-2 bg-dark text-white text-center">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control Cursos
                        </h1>
                    </div>
                </div>
            </div>
        </div>
        <main>
            <section id = "curso">
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
                                        <h5 class="modal-title" id="exampleModalLabel">Agregar curso</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <form method="POST" action="${pageContext.request.contextPath}/ServletCursoController" class ="was-validated">
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                <label for="ciclo" class="form-label">Ciclo</label>
                                                <input type="number" class="form-control" name="ciclo" id="ciclo" min="2021" step="1" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="cupoMaximo" class="form-label">Cupo Máximo</label>
                                                <input type="number" class="form-control" name="cupoMaximo" id="cupoMaximo" min="0" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="cupoMinimo" class="form-label">Cupo Mínimo</label>
                                                <input type="number" class="form-control" name="cupoMinimo" id="cupoMinimo" min="0" required>
                                            </div>
                                            <div class="mb-3">
                                                <label for="descripcion" class="form-label">Descripción</label>
                                                <input type="text" class="form-control" name="descripcion" id="descripcion" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="carreraTecnica" class="form-label">Código Carrera</label>
                                                <select class="form-control" name="codigoCarrera" id="codigoCarrera">
                                                    <c:forEach var="carreraTecnica" items="${listadoCarreraTecnica}">
                                                        <tr>
                                                        <option>${carreraTecnica.codigoCarrera}</option>
                                                        </tr>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="horarioId" class="form-label">Horario Id</label>
                                                <select class="form-control" name="horarioId" id="horarioId">
                                                    <c:forEach var="horario" items="${listadoHorario}">
                                                        <tr>
                                                        <option >${horario.idHorario}</option>
                                                        </tr>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="instructorId" class="form-label">Instructor Id</label>
                                                <select class="form-control" name="instructorId" id="instructorId">
                                                    <c:forEach var="instructor" items="${listadoInstructor}">
                                                        <tr>
                                                        <option>${instructor.instructorId}</option>
                                                        </tr>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="salonId" class="form-label">Salón Id</label>
                                                <select class="form-control" name="salonId" id="salonId">
                                                    <c:forEach var="salon" items ="${listadoSalones}">
                                                        <tr>
                                                        <option>${salon.salonId}</option>
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
                            <div class="card" id="card-curso">
                                <div class="card-header">
                                    <h4><i class="fas fa-address-book"></i>        Cursos</h4>
                                </div>
                            </div>
                            <table class="table table-dark table-hover"">
                                <thead class="table-dark table-hover">
                                    <tr>
                                        <th>ID</th>
                                        <th>Ciclo</th>
                                        <th>Cupo Máximo</th>
                                        <th>Cupo Mínimo</th>
                                        <th>Descripción</th>
                                        <th>Código Carrera</th>
                                        <th>Nombre Carrera</th>
                                        <th>Horario Id</th>
                                        <th>Horario Inicio</th>
                                        <th>Horario HoraFinal</th>
                                        <th>Instructor Id</th>
                                        <th>Nombre Instructor</th>
                                        <th>Salón Id</th>
                                        <th>Descripción Salón</th>
                                        <th>    </th>
                                        <th>    </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="curso" items="${listadoCurso}">
                                        <tr>
                                            <td>${curso.cursoId}</td>
                                            <td>${curso.ciclo}</td>
                                            <td>${curso.cupoMaximo}</td>
                                            <td>${curso.cupoMinimo}</td>
                                            <td>${curso.descripcion}</td>
                                            <td>${curso.codigoCarrera}</td>
                                            <td>${curso.nombre}</td>
                                            <td>${curso.horarioId}</td>
                                            <td>${curso.horaInicio}</td>
                                            <td>${curso.horaFinal}</td>
                                            <td>${curso.instructorId}</td>
                                            <td>${curso.nombres}</td>
                                            <td>${curso.salonId}</td>
                                            <td>${curso.descripcionSalon}</td>
                                            <td><a class = "btn btn-warning" href="${pageContext.request.contextPath}/ServletCursoController?accion=editar&cursoId=${curso.cursoId}"><i class="far fa-edit"></i>    Editar</a></td>
                                            <td><a class = "btn btn-danger"  href="${pageContext.request.contextPath}/ServletCursoController?accion=eliminar&cursoId=${curso.cursoId}" id="deleteBtn" type="button"><i class="fas fa-trash"></i>    Eliminar</a></td>
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