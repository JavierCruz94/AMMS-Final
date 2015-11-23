package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;
import controles.ControlProyecto;

  public class InterfazConsultarProyecto extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlProyecto cp;

   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("<link rel=stylesheet href=css/bootstrap.min.css>");
    out.println("<link rel=stylesheet href=style.css>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Vinculacion Academica</TITLE>");
    out.println("<h2>Consulta de proyectos</h2>");

    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarConsultaP();
    }else if(operacion.equals("consultar")){
        consultaP();
    }
  }

  public void iniciarConsultaP(){
    out.println("<p>Ingrese ID del Proyecto</p>");
    out.println("<form method=\"GET\" action=\"ConsultarProyecto\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"consultar\"/>");
    out.println("<p> Id del Proyecto  <input type=\"text\" name=\"idProy\" size=\"15\"></p>");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Consultar</button>");
    out.println("</form>");

    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<button class=\"btn btn-danger \"type=\"submit\">Cancelar</button>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void consultaP(){
      cp = new ControlProyecto();
      String idProyecto = thisRequest.getParameter("idProy").trim();

      String idAdministrador = cp.getIdAdmin(idProyecto);
      String idUsuario = cp.getIdUsu(idProyecto);
      String instNacional = cp.getInstitucionNacional(idProyecto);
      String nombreInstitucion = cp.getNombreInstitucion(idProyecto);
      String nombreProyecto = cp.getNombreProyecto(idProyecto);
      String intencionEducativa = cp.getIntencionEducativa(idProyecto);
      String objetivoProyecto = cp.getObjetivoProy(idProyecto);
      String actividad = cp.getActividades(idProyecto);
      int intC = cp.getCRN(idProyecto);
      int numAlumnos = cp.getNumAlumnosIn(idProyecto);
      int areaDisciplinar = cp.getAreasDiciplinar(idProyecto);
      String encargado = cp.getEncargado(idProyecto);


      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<h2> Proyecto con ID " + idProyecto + "</h2>");
      out.println("<p> ID administrador: " + idAdministrador + "</p>");
      out.println("<p> ID usuario: " + idUsuario + "</p>");
      out.println("<p> InstitucionNacional: " + instNacional + "</p>");
      out.println("<p> Nombre de la Institucion: " + nombreInstitucion + "</p>");
      out.println("<p> Intencion Educativa: " + intencionEducativa + "</p>");
      out.println("<p> Objetivo del Proyecto: " +objetivoProyecto  + "</p>");
      out.println("<p> Activad: " + actividad + "</p>");
      out.println("<p> CRN: " + intC + "</p>");
      out.println("<p> Numero de alumnos: " + numAlumnos + "</p>");
      out.println("<p> Area diciplinar: " + areaDisciplinar + "</p>");
      out.println("<p> Encargado: " + encargado + "</p>");
      out.println("<form method=\"GET\" action=\"menuPrivi.html\">");
      out.println("<button class=\"btn btn-danger \"type=\"submit\">Cancelar</button>");
      out.println("</form>");
      }


}
