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
    out.println("<TITLE>Viculacion Academica</TITLE>");
    out.println("<h2>Viculacion Academica</h2>");
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
  out.println("<form method=\"GET\" action=\"InicioS\">");
  out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
  out.println("<div class=row>");
  out.println("<div class=\"col-xs-2\">");
  out.println("<p><input type=\"text\" name=\"cuentaP\"class=\"form-control\"placeholder=\"Ingresar ID\"></p>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div class=row>");
  out.println("<div class=\"col-xs-2\">");
  out.println("<p><input type=\"text\" name=\"contraP\"class=\"form-control\"placeholder=\"Password\"></p>");
  out.println("</div>");
  out.println("</div>");
  out.println("<button class=\"btn btn-info \"type=\"submit\">Enviar</button>");
  out.println("</form>");

  out.println("<form method=\"GET\" action=\"index.html\">");
  out.println("<button class=\"btn btn-danger \"type=\"submit\">Cancelar</button>");
  out.println("</form>");

  out.println("</BODY>");
  out.println("</HTML>");
}

public void validarCuenta(){
  cu = new ControlUsuario();
  ca = new ControlAdministrador();
  String cuenta = thisRequest.getParameter("cuentaP").trim();
  String contra = thisRequest.getParameter("contraP").trim();
   //String.parseStr(thisRequest.getParameter("cuentaP").trim())
  if (cu.iSusuario(cuenta,contra) || ca.iSAdmin(cuenta,contra)){
     IniciaSesion();
  } else {
    out.println("<p>Ingrese ID/Password de nuevo</p>");
     IniciarSesionPagina();
  }
}

public void IniciaSesion(){
  cu = new ControlUsuario();
  ca = new ControlAdministrador();
  String cuenta = thisRequest.getParameter("cuentaP").trim();

  out.println("<p>Bienvenido!</p>");
  out.println("<p>Presione el boton para continuar.</p>");
  if(ca.validarIDAdministrador(cuenta)){
    out.println("<form method=\"GET\" action=\"menuAdmin.html\">");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Continuar</button>");
  }
  else if(cu.getPrivilegio(cuenta)){
    out.println("<form method=\"GET\" action=\"menuPrivi.html\">");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Continuar</button>");
  }
  else{
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<button class=\"btn btn-info \"type=\"submit\">Continuar</button>");
  }
  out.println("</form>");
  out.println("</BODY>");
  out.println("</HTML>");
}

}
