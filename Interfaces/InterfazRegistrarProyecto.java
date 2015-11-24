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
    out.println("<h2>Viculacion Academica</h2>");
    out.println("<h3>Registro de proyectos</h3>");


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
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"idAdmin\"class=\"form-control\"placeholder=\" Id Administrador\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"idUsu\"class=\"form-control\"placeholder=\"Id Usuario\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"instNac\"class=\"form-control\"placeholder=\"Institucion Nacional\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"nomInst\"class=\"form-control\"placeholder=\"Nombre Institucion\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"nomInst\"class=\"form-control\"placeholder=\"Nombre Institucion\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"nomPro\"class=\"form-control\"placeholder=\"Nombre Proyecto\"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><textarea name=\"intEd\"class=\"form-control\"placeholder=\"Intencion Educativa\"rows=\"3\"></textarea></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><textarea name=\"objProy\"class=\"form-control\"placeholder=\"Objetivo del Proyecto\"rows=\"3\"></textarea></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><textarea name=\"act\"class=\"form-control\"placeholder=\"Actividades\"rows=\"3\"></textarea></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"enc\"class=\"form-control\"placeholder=\" Encargado \"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"idProy\"class=\"form-control\"placeholder=\" Id del Proyecto \"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"cr\"class=\"form-control\"placeholder=\" CRN \"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"numAl\"class=\"form-control\"placeholder=\" Numero de Alumnos \"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=row>");
    out.println("<div class=\"col-xs-3\">");
    out.println("<p><input type=\"text\" name=\"areaDi\"class=\"form-control\"placeholder=\" Area Disciplinar \"></p>");
    out.println("</div>");
    out.println("</div>");
    out.println("<input type=\"hidden\" name=\"tipo\" value=\"" + tipo_usuario + "\"/>");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Agregar</button>");
    out.println("</form>");

    if (tipo_usuario.equals("1")) {
      out.println("<form method=\"GET\" action=\"menuAdmin.html?tipo=1\">");

    } else if (tipo_usuario.equals("2")){
      out.println("<form method=\"GET\" action=\"menuPrivi.html?tipo=2\">");

    }

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

      boolean valido = cp.validarProyecto(idProyecto);
      if (valido) {
        cp.agregarProy(idAdministrador, idUsuario, instNacional, nombreInstitucion, nombreProyecto, intencionEducativa, objetivoProyecto, actividad, intC, numAlumnos, areaDisciplinar, encargado, idProyecto);

        if (tipo_usuario.equals("1")) {
          out.println("<form method=\"GET\" action=\"menuAdmin.html?tipo=1\">");

        } else if (tipo_usuario.equals("2")){
          out.println("<form method=\"GET\" action=\"menuPrivi.html?tipo=2\">");

        }

        out.println("<h4> Proyecto agregado!</h4>");
        out.println("<button class=\"btn btn-danger \"type=\"submit\">Terminar</button>");
        out.println("</form>");
      } else {
        out.println("<h3>Ya existe un proyecto con ese ID, ingresa otro</h3>");
         iniciarRegistroP();
      }
    }
}
