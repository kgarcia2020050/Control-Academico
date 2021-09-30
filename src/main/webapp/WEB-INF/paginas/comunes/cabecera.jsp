<header id="equipo3-header">
    <h1> Control de Asignaciones y Clases </h1>
</header>

<div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
        <a class="nav-link active text-white" aria-current="page" href="${pageContext.request.contextPath}/inicio.jsp"><i class="fas fa-home"></i> Inicio</a>
        <a class="nav-link active text-white"  aria-current="page"  href="${pageContext.request.contextPath}/ServletAlumnoController?accion=listar"><i class="fas fa-user-graduate"></i>  Alumnos</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletSalonController?accion=listar"><i class="fas fa-chalkboard"></i>  Salones</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletHorarioController?accion=listar"><i class="fas fa-calendar-alt"></i>  Horarios</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletCarreraTecnicaController?accion=listar"><i class="fas fa-book"></i>  Carreras Técnicas</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletInstructorController?accion=listar"><i class="fas fa-chalkboard-teacher"></i>  Instructores</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletCursoController?accion=listar"><i class="fas fa-address-book"></i> Cursos</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletAsignacionAlumnoController?accion=listar"><i class="fas fa-file-signature"></i>  Asignaciones</a>
        <a class="nav-link active text-white"  aria-current="page" href="${pageContext.request.contextPath}/ServletNotaController?accion=listar"><i class="fas fa-graduation-cap"></i>  Notas</a>
    </div>
</div>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span> Menú 
        </button>
        <button>
            <a class="nav-link active bg-dark text-white"  aria-current="page" data-bs-toggle="modal" data-bs-target="#logOutModal"><i class="fas fa-sign-out-alt"></i>  LogOut</a>
        </button>
        <!-- Modal -->
        <div class="modal fade" id="logOutModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-dark">
                        <h5 class="modal-title text-white" id="exampleModalLabel">LogOut</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿Desea Salir de la Sesión?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/login.jsp">Salir</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
