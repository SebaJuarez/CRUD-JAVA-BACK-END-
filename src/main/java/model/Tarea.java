
package model;

import java.sql.Date;

public class Tarea {
    private int idTarea;
    private String titulo;
    private String descripcion;
    private boolean realizada;
    private Date fechaVencimiento;
    private int idProjects;

    public Tarea(int idTarea, String titulo, String descripcion, boolean realizada, Date fechaVencimiento, int idProjects) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.fechaVencimiento = fechaVencimiento;
        this.idProjects = idProjects;
    }

        public Tarea(String titulo, String descripcion, boolean realizada, Date fechaVencimiento, int idProjects) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.fechaVencimiento = fechaVencimiento;
        this.idProjects = idProjects;
    }

    public Tarea(String titulo, String descripcion, boolean realizada, Date fechaVencimiento) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.fechaVencimiento = fechaVencimiento;
    }   
    
        public Tarea(int idTarea, String titulo, String descripcion, boolean realizada, Date fechaVencimiento) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.realizada = realizada;
        this.fechaVencimiento = fechaVencimiento;
    }    
    
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdProjects() {
        return idProjects;
    }

    public void setIdProjects(int idProjects) {
        this.idProjects = idProjects;
    }
    
    @Override
    public String toString(){
        String respuesta ;
        respuesta = "----------------------------------";
        respuesta += "id : " + this.idTarea + " \n"
                + "titulo : " + this.titulo + "\n"
                + "descripcion : " + this.descripcion + "\n"
                + "fecha vencimiento : " + this.fechaVencimiento + "\n"
                + "realizada? : " + this.realizada + "\n"
                + "id proyecto : " + this.idProjects;
        return respuesta;
    }
    
}

