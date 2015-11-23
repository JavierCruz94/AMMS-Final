package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazCerrarS extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlUsuario cu;
  ControlAdministrador ca;
  //String cuentaP;

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
    //out.println("<TITLE>Viculacion Academica</TITLE>");
    out.println("<h2>Viculacion Academica</h2>");
    //out.println("<p>Esta opci�n no esta disponible por el momento.</p>");

  String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      CerrarSesionPagina();
    }else if(operacion.equals("validar")){
      // validarCuenta();
    }
  }

  public void CerrarSesionPagina(){
  out.println("<p>Cerro sesion exitosamente</p>");
  out.println("<form method=\"GET\" action=\"CerrarS\">");
  out.println("</form>");
  out.println("<form method=\"GET\" action=\"index.html\">");
  out.println("<button class=\"btn btn-info \"type=\"submit\">Confirmar</button>");
  out.println("</form>");
  out.println("</BODY>");
  out.println("</HTML>");
  }
}
