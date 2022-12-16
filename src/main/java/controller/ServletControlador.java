package controller;

import data.TareaDao;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Tarea;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");
        if (accionJava != null) {
            switch (accionJava) {
                case "editar":
                    editarTarea(req, resp);
                    break;
                case "eliminar":
                    eliminarTarea(req,resp);
                    break;
                default:
                    break;
            }
        } else {
            accionDefault(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accionJava = req.getParameter("accion");
        System.out.println("entreeeeeeeeee al doPost con "+ accionJava);
        if (accionJava != null) {
            switch (accionJava) {
                case "insertar":
                    insertarTarea(req, resp);
                    break;
                case "modificar":
                    modificarTarea(req,resp);
                    break;
                default:
                    break;
            }
        } else {
            accionDefault(req, resp);
        }
    }

    private int calcularRealizadas(List<Tarea> tareas) {
       return  tareas.stream().
               filter(tarea -> tarea.isRealizada()).
               collect(Collectors.toList()).
               size();
    }

    private void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TareaDao tarea = new TareaDao();
        List<Tarea> tareas = tarea.seleccionar();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("tareas", tareas);
        sesion.setAttribute("totalTareas", tareas.size());
        sesion.setAttribute("totalRealizadas", calcularRealizadas(tareas));
        resp.sendRedirect("tareas.jsp");
    }

    private void insertarTarea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date fechaLimite;
        Boolean realizada;
        String titulo = req.getParameter("titulo");
        String descripcion = req.getParameter("descripcion");
        try {
            fechaLimite = Date.valueOf(req.getParameter("fechaLimite"));
        } catch (Exception e) {
            fechaLimite = null;
        }
        if(req.getParameter("realizada") == null){
            realizada = false;
        } else realizada = true;
        Tarea tarea = new Tarea(titulo, descripcion, realizada, fechaLimite);
        int regMod = new TareaDao().insertar(tarea);
        System.out.println("reg guardados "+ regMod);
        accionDefault(req, resp);
    }

    private void editarTarea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        int idTarea = Integer.parseInt(req.getParameter("idTarea"));
        Tarea tarea = new TareaDao().seleccionarPorId(idTarea);
        System.out.println("Tarea recuperada----- " + tarea.toString());
        req.setAttribute("tarea", tarea);
        String jspEditar = "/WEB-INF/paginas/operaciones/editarTarea.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }

    private void modificarTarea(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Date fechaLimite;
        Boolean realizada;
        String titulo = req.getParameter("titulo");
        String descripcion = req.getParameter("descripcion");
        int idTarea = Integer.parseInt(req.getParameter("idTarea"));
        try {
            fechaLimite = Date.valueOf(req.getParameter("fechaLimite"));
        } catch (Exception e) {
            fechaLimite = null;
        }
        if(req.getParameter("realizada") == null){
            realizada = false;
        } else realizada = true;
        Tarea tarea = new Tarea(idTarea, titulo, descripcion, realizada, fechaLimite);
        int regMod = new TareaDao().actualizar(tarea);
        System.out.println("reg guardados "+ regMod);
        accionDefault(req, resp);
    }

    private void eliminarTarea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        int idTarea = Integer.parseInt(req.getParameter("idTarea"));
        int regMod = 0;
        try {
            regMod = new TareaDao().eliminar(idTarea);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("reg guardados "+ regMod);
        accionDefault(req, resp);
    }
    

}
