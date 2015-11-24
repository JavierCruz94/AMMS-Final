package interfaces;
import controles.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlUsuario;
import controles.ControlAdministrador;

  public class InterfazCambioPrivi extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlUsuario cu;
  ControlAdministrador ca;
  String tipo_usuario;
  //String cuentaP;

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
    out.println("<TITLE>Viculacion Academica</TITLE>");
    out.println("<h2>Cambio de privilegio a un usuario</h2>");
    //out.println("<p>Esta opci�n no esta disponible por el momento.</p>");

  String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      IniciarCambioPrivi();
    }else if(operacion.equals("cambio")){
       ValidarUsusarioi();
    }
  }

  public void IniciarCambioPrivi(){
  out.println("<p>Ingrese el ID dle usuario</p>");
  out.println("<form method=\"GET\" action=\"CambioP\">");
  out.println("<input type=\"hidden\" name=\"operacion\" value=\"cambio\"/>");
  out.println("<div class=row>");
  out.println("<div class=\"col-xs-2\">");
  out.println("<p><input type=\"text\" name=\"cuentaP\"class=\"form-control\"placeholder=\"Cuenta\"></p>");
  out.println("</div>");
  out.println("</div>");
  out.println("<div class=row>");
  out.println("<div class=\"col-xs-2\">");
  out.println("<p><input type=\"text\" name=\"Privi\"class=\"form-control\"placeholder=\"Privilegio\"></p>");
  out.println("</div>");
  out.println("</div>");
  out.println("<input type=\"hidden\" name=\"tipo\" value=\"" + tipo_usuario + "\"/>");
  out.println("<button class=\"btn btn-info \"type=\"submit\">Enviar</button>");
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

  public void ValidarUsusarioi(){
    cu = new ControlUsuario();
    String cuenta = thisRequest.getParameter("cuentaP").trim();
    int privi = Integer.parseInt(thisRequest.getParameter("Privi").trim());
    boolean existe = cu.validarIDUsuario(cuenta);
    if (cu.validarIDUsuario(cuenta)){
        cu.setPrivilegio(cuenta,privi);
          VlidacionCambio();
    } else {
      out.println("<p>Usuario no existe vuelva a ingresar ID </p>");
       IniciarCambioPrivi();
    }
  }

  public void VlidacionCambio(){
    out.println("<p>Cambio fue exitoso</p>");

    if (tipo_usuario.equals("1")) {
      out.println("<form method=\"GET\" action=\"menuAdmin.html?tipo=1\">");

    } else if (tipo_usuario.equals("2")){
      out.println("<form method=\"GET\" action=\"menuPrivi.html?tipo=2\">");

    }
    out.println("<button class=\"btn btn-danger \"type=\"submit\">Terminar</button>");
    out.println("</form>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

}
