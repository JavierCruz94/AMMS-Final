package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazInicioS extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlUsuario cu;
  ControlAdministrador ca;
  String cuenta;

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
    out.println("<h3>Inicio sesion</h3>");
    //out.println("<p>Esta opci�n no esta disponible por el momento.</p>");

  String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      IniciarSesionPagina();
    }else if(operacion.equals("validar")){
       validarCuenta();
    }
  }

  public void IniciarSesionPagina(){
  out.println("<p>Ingrese su matricula</p>");
  out.println("<form method=\"GET\" action=\"InicioS\">");
  out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
  out.println("<p> Cuenta  <input type=\"text\" name=\"cuentaP\" size=\"15\"></p>");
  out.println("<p><input type=\"submit\" value=\"Enviar\"></p>");
  out.println("</form>");

  out.println("<form method=\"GET\" action=\"index.html\">");
  out.println("<p><input type=\"submit\" value=\"Cancelar\"></p>");
  out.println("</form>");

  out.println("</BODY>");
  out.println("</HTML>");
}

public void validarCuenta(){
  cu = new ControlUsuario();
  ca = new ControlAdministrador();
  cuenta = thisRequest.getParameter("cuentaP").trim(); //String.parseStr(thisRequest.getParameter("cuentaP").trim())
  boolean existe = cu.validarIDUsuario(cuenta);
  if (cu.validarIDUsuario(cuenta) || ca.validarIDAdministrador(cuenta)){
     IniciaSesion();
  } else {
    out.println("<p>Ingrese matricula denuvo</p>");
     IniciarSesionPagina();
  }
}

public void IniciaSesion(){
  cu = new ControlUsuario();
  ca = new ControlAdministrador();

  out.println("<HEAD>Acciones</HEAD>");
  out.println("<p>Bienvenido!</p>");
  out.println("<p>Presione el boton para continuar.</p>");
  if(ca.validarIDAdministrador(cuenta) || cu.getPrivilegio(cuenta)){
    out.println("<form method=\"GET\" action=\"menuPrivi.html\">");
    out.println("<p><input type=\"submit\" value=\"Continuar\"name=\"B1\"></p>");
  }
  else{
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Continuar\"name=\"B1\"></p>");
  }
  out.println("</form>");
  out.println("</BODY>");
  out.println("</HTML>");
  }
}
