package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazMapeo extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  String tipo_usuario;

   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    tipo_usuario =thisRequest.getParameter("tipo");
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
    out.println("<h2>Mapeo de proyectos</h2>");
    out.println("<address>");
    out.println("<strong>Twitter, Inc.</strong><br>");
    out.println("1355 Market Street, Suite 900<br>");
    out.println("San Francisco, CA 94103<br>");
    out.println("<abbr title=Phone>P:</abbr> (123) 456-7890");
    out.println("</address>");
    out.println("<img src=sampleMap.JPG alt=... class=img-rounded>");
    if(tipo_usuario.equals("1")) {
      out.println("<form method=\"GET\" action=\"menuAdmin.html?tipo=1\">");
    } else if (tipo_usuario.equals("2")) {
      out.println("<form method=\"GET\" action=\"menuPrivi.html?tipo=2\">");
    }
    else if (tipo_usuario.equals("3")) {
    out.println("<form method=\"GET\" action=\"menu.html?tipo=3\">");
  }

    out.println("<button class=\"btn btn-danger \"type=\"submit\">Terminar</button>");
  }

}
