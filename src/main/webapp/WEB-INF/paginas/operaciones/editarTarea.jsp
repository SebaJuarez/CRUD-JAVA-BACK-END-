<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Tareas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body>
        <jsp:include page="../comunes/cabecera.jsp"></jsp:include>
    <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idTarea=${tarea.idTarea}" 
         method="POST" class="was-validated">
        <jsp:include page="../comunes/botonesNavegacionEditar.jsp"></jsp:include>        
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Modificar Tarea</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="titulo">Titulo</label>
                                        <input type="text" class="form-control" name="titulo" value="${tarea.titulo}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="descripcion">Descripcion</label>
                                        <input type="text" class="form-control" name="descripcion" value="${tarea.descripcion}" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="fechaLimite">Fecha limite</label>
                                        <input type="date" class="form-control" name="fechaLimite" value="${tarea.fechaVencimiento}">
                                    </div>
                                    <div class="form-group">
                                        <label for="realizada">Realizada</label>
                                        <input class="form-check-input mt-1" type="checkbox" ${(tarea.realizada)? "checked" : ""} value="realizada?" aria-label="Checkbox for following text input" name="realizada">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
    </fom>
    <jsp:include page="../comunes/pieDePagina.jsp"></jsp:include> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
