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
  String tipo_usuario;

   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    tipo_usuario = thisRequest.getParameter("tipo");
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
    out.println("<p>El tipo de usuario es: " + tipo_usuario + "</p>");
    out.println("<p>Ingrese ID del Proyecto</p>");
    out.println("<form method=\"GET\" action=\"ConsultarProyecto\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"consultar\"/>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-2\">");
    out.println("<p><input type=\"text\" name=\"idProy\"class=\"form-control\"placeholder=\"Ingresar ID de proyecto\"></p>");
    out.println("</div>");
    out.println("</div>");


    out.println("<input type=\"hidden\" name=\"tipo\" value=\"" + tipo_usuario + "\"/>");

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

      boolean existe = cp.validarProyecto(idProyecto);
      System.out.println(existe);
      if (existe) {
        out.println("<h3> No hay proyectos con ese ID, ingrese otro</h3>");
        iniciarConsultaP();
      } else {
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



      if(tipo_usuario.equals("1")) {
        out.println("<form method=\"GET\" action=\"menuAdmin.html\">");
        System.out.println("entra a tipo de usuario 1");
      } else if(tipo_usuario.equals("2")) {
        out.println("<form method=\"GET\" action=\"menuPrivi.html\">");
        System.out.println("entra a tipo de usuario 2");

      } else if (tipo_usuario.equals("3")) {
        out.println("<form method=\"GET\" action=\"menu.html\">");
        System.out.println("entra a tipo de usuario 3");
        System.out.println(tipo_usuario);


      }
      out.println("<p> El tipo de usuario aqui es: " + tipo_usuario + "</p>");
      out.println("<h3> Proyecto con ID " + idProyecto + "</h3>");
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
      out.println("<button class=\"btn btn-danger \"type=\"submit\">Cancelar</button>");
      out.println("</form>");
    }
  }
}
