package data;

import model.Tarea;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class TareaDao{
    
    private final Conexion con = new Conexion();
    private static final String SQL_SELECT = "SELECT * FROM tareas";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM tareas WHERE idTareas = ?";
    private static final String SQL_INSERT = "INSERT INTO tareas(Titulo, Descripcion, Realizada, FechaVencimiento, idProjects) VALUES(?, ?, ?,?,?)";   
    private static final String SQL_UPDATE = "UPDATE tareas SET Titulo = ?, Descripcion = ?, Realizada = ?, FechaVencimiento = ?  WHERE idTareas = ?";
    private static final String SQL_DELETE = "DELETE FROM tareas WHERE idTareas = ?";
    
    public List<Tarea> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea ;
        List<Tarea> tareas = new ArrayList();
        try {
            conn = con.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTarea = rs.getInt(1);
                String titulo = rs.getString("Titulo");
                String descripcion = rs.getString("Descripcion");
                Boolean realizada = rs.getBoolean("Realizada");
                Date fechaVencimiento = rs.getDate("FechaVencimiento");
                int idProjects = rs.getInt("idProjects");
                tarea = new Tarea(idTarea, titulo, descripcion, realizada, fechaVencimiento, idProjects);
                tareas.add(tarea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                con.close(rs);
                con.close(stmt);
                con.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return tareas;
    }
    
     public Tarea seleccionarPorId(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarea tarea = null;

        try {
            conn = con.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idTarea = rs.getInt(1);
                String titulo = rs.getString("Titulo");
                String descripcion = rs.getString("Descripcion");
                Boolean realizada = rs.getBoolean("Realizada");
                Date fechaVencimiento = rs.getDate("FechaVencimiento");
                int idProjects = rs.getInt("idProjects");
                tarea = new Tarea(idTarea, titulo, descripcion, realizada, fechaVencimiento, idProjects);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                con.close(rs);
                con.close(stmt);
                con.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return tarea;
    }
    
    public int insertar(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = con.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tarea.getTitulo());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setBoolean(3,tarea.isRealizada());
            stmt.setDate(4,tarea.getFechaVencimiento());
            stmt.setInt(5, 1);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                con.close(stmt);
                con.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Tarea tarea){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = con.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tarea.getTitulo());
            stmt.setString(2, tarea.getDescripcion());
            stmt.setBoolean(3, tarea.isRealizada());
            stmt.setDate(4, tarea.getFechaVencimiento());
            stmt.setInt(5, tarea.getIdTarea());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                con.close(stmt);
                con.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
      
     public int eliminar(int idTarea) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = con.getConexion();
            
            stmt = conn.prepareStatement(SQL_DELETE);
            
            stmt.setInt(1, idTarea);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                con.close(stmt);
                con.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}

