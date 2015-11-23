package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazRegistrarProyecto extends HttpServlet {
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
    out.println("<h2>Registro de proyectos</h2>");

    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarRegistroP();
    }else if(operacion.equals("registrar")){
        registroP();
    }
  }

  public void iniciarRegistroP(){
    out.println("<p>Llene los siguientes campos</p>");
    out.println("<form method=\"GET\" action=\"RegistrarProyecto\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"registrar\"/>");
    out.println("<p> Id Administrador  <input type=\"text\" name=\"idAdmin\" size=\"15\"></p>");
    out.println("<p> Id Usuario  <input type=\"text\" name=\"idUsu\" size=\"15\"></p>");
    out.println("<p> Institucion Nacional  <input type=\"text\" name=\"instNac\" size=\"15\"></p>");
    out.println("<p> Nombre Institucion  <input type=\"text\" name=\"nomInst\" size=\"15\"></p>");
    out.println("<p> Nombre Proyecto  <input type=\"text\" name=\"nomPro\" size=\"15\"></p>");
    out.println("<p> Intencion Educativa  <input type=\"text\" name=\"intEd\" size=\"15\"></p>");
    out.println("<p> Objetivo del Proyecto  <input type=\"text\" name=\"objProy\" size=\"15\"></p>");
    out.println("<p> Actividad  <input type=\"text\" name=\"act\" size=\"15\"></p>");
    out.println("<p> Encargado  <input type=\"text\" name=\"enc\" size=\"15\"></p>");
    out.println("<p> Id del Proyecto  <input type=\"text\" name=\"idProy\" size=\"15\"></p>");
    out.println("<p> CRN  <input type=\"text\" name=\"cr\" size=\"15\"></p>");
    out.println("<p> Numero de Alumnos  <input type=\"text\" name=\"numAl\" size=\"15\"></p>");
    out.println("<p> Area Disciplinar  <input type=\"text\" name=\"areaDi\" size=\"15\"></p>");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Agregar</button>");
    out.println("</form>");

    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<button class=\"btn btn-danger \"type=\"submit\">Cancelar</button>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void registroP(){
      cp = new ControlProyecto();
      String idAdministrador = thisRequest.getParameter("idAdmin").trim();
      String idUsuario = thisRequest.getParameter("idUsu").trim();
      String instNacional = thisRequest.getParameter("instNac").trim();
      String nombreInstitucion = thisRequest.getParameter("nomInst").trim();
      String nombreProyecto = thisRequest.getParameter("nomPro").trim();
      String intencionEducativa = thisRequest.getParameter("intEd").trim();
      String objetivoProyecto = thisRequest.getParameter("objProy").trim();
      String actividad = thisRequest.getParameter("act").trim();
      int intC = Integer.parseInt(thisRequest.getParameter("cr").trim());
      int numAlumnos = Integer.parseInt(thisRequest.getParameter("numAl").trim());
      int areaDisciplinar = Integer.parseInt(thisRequest.getParameter("areaDi").trim());
      String encargado = thisRequest.getParameter("enc").trim();
      String idProyecto = thisRequest.getParameter("idProy").trim();
      cp.agregarProy(idAdministrador, idUsuario, instNacional, nombreInstitucion, nombreProyecto, intencionEducativa, objetivoProyecto, actividad, intC, numAlumnos, areaDisciplinar, encargado, idProyecto);

      out.println("<form method=\"GET\" action=\"menuPrivi.html\">");
      out.println("<h2> Proyecto agregado!</h2>");
      out.println("<button class=\"btn btn-danger \"type=\"submit\">Terminar</button>");
      out.println("</form>");
      }
}
