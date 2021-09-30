<%-- 
    Document   : index
    Created on : 25/08/2021, 09:27:32 AM
    Author     : Brandon Andree Palma Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/d30c7c2674.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <title>Página Principal</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp" />
        <main>
            <div class="container pn-4 pt-4 pb-4">
                <div class="container text-center text-black bg-white py-4">
                    <div class="container">
                        <h2 >BIENVENIDO</h2><hr>
                        <h3> Esta página web permite llevar un control sobre asignaciones y cursos de alumnos, salones, horarios, carreras técnicas e instructores</h3>
                        <div class="container py-4">
                            <img src="assets/img/Product Manager_Monochromatic.svg">
                        </div>
                        <h3> y recuerda siempre "El trabajo bien hecho".</h3>
                    </div>  
                </div> 
            </div>
        </main>
        <div>
            <br>
            <br>
            <br>
        </div>
        <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp" />
        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>
