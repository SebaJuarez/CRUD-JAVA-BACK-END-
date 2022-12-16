<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_ES"/>
<section id="tareas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>
                            Listado de Tareas
                        </h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>titulo</th>
                                <th>descripcion</th>
                                <th>fecha limite</th>
                                <th>realizada</th>
                                <th>-</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tarea" items="${tareas}" varStatus="status">
                                <tr>
                                    <td>
                                        ${status.count}
                                    </td>
                                    <td>
                                        ${tarea.titulo}
                                    </td>
                                    <td>
                                        ${tarea.descripcion}
                                    </td>
                                    <td>
                                        ${(tarea.fechaVencimiento == null)? "sin limite" : tarea.fechaVencimiento.toString()}
                                    </td>
                                    <td>
                                       ${(tarea.realizada)? "si" : "no"}
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idTarea=${tarea.idTarea}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de tareas</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${totalTareas}</h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Tareas realizadas</h3>
                        <h4 class="display-4"><i class="fas fa-users"></i>${totalRealizadas}</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarTarea.jsp"/>