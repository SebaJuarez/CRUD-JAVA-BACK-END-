<div class="modal fade" id="agregarTareaModal" tabindex="-1" aria-labelledby="agregarTareaModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Libro</h5>
                <button type="button" class="btn-close" data-bs-dismiss ="modal" aria-label="close"> 
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="titulo">Titulo</label>
                        <input type="text" class="form-control" name="titulo" required>
                    </div>
                     <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaLimite">Fecha limite</label>
                        <input type="date" class="form-control" name="fechaLimite">
                    </div>
                    <div class="form-group">
                        <label for="realizada">Realizada</label>
                        <input class="form-check-input mt-1" type="checkbox" value="" aria-label="Checkbox for following text input" name="realizada">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>