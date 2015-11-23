package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazUsuarioN extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlUsuario cu;
  ControlAdministrador ca;

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
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Viculacion Academica</TITLE>");
    out.println("<h2>Mapeo y registro de proyectos</h2>");
    out.println("<h3>Dar de alta un ususario</h3>");
    //out.println("<p>Esta opci�n no esta disponible por el momento.</p>");

  String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      IniciarUsuarioNuevo();
    }else if(operacion.equals("usuarioNuevo")){
       //validarDatos();
    }
  }

 public void IniciarUsuarioNuevo(){

  out.println("<p>Ingrese los datos para dar de alta un usario</p>");
  out.println("<form method=\"GET\" action=\"UsuarioN\">");
  out.println("<input type=\"hidden\" name=\"operacion\" value=\"usuarioNuevo\"/>");
  out.println("<p> Ingrese su ID <input type=\"text\" name=\"cuentaPrivi\" size=\"15\"></p>");
  out.println("<p> Ingrese su ID de la persona <input type=\"text\" name=\"cuentaUsuario\" size=\"15\"></p>");
  out.println("<p> Ingrese su ID de nuevo usario <input type=\"text\" name=\"cuentaUsuario\" size=\"15\"></p>");
  out.println("<p> Ingrese contrasena <input type=\"text\" name=\"contraU\" size=\"15\"></p>");
  out.println("<p> Privilegio (si = 1, no = 0)<input type=\"text\" name=\"cuentaP\" size=\"15\"></p>");
  out.println("<p> Ingrese su ID <input type=\"text\" name=\"cuentaP\" size=\"15\"></p>");
  out.println("<p><input type=\"submit\" value=\"Enviar\"></p>");
  out.println("</form>");

  out.println("<form method=\"GET\" action=\"index.html\">");
  out.println("<p><input type=\"submit\" value=\"Cancelar\"></p>");
  out.println("</form>");

  out.println("</BODY>");
  out.println("</HTML>");
}

/*public void validarDatos(){

}*/
}
