package entidades;
import java.sql.*;
import java.io.*;

public class Proyecto {
   Connection conn;
   Statement stmt;

   public Proyecto(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/vinculacion";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }

   public void agregarProyecto (String idAdministrador, String idUsuario,
      String institucionNacional, String nombreInstitucion, String nombreProyecto,
      String intencionEducativa, String objetivoProyecto, String actividad,
      int crn, int numALumnos, int areaDisciplinar, String encargado, String idProyecto) {
     try {
       String s = "INSERT INTO PROYECTO (IdAdministrador, IdUsuario, InstitucionNacional, " +
       "NombreInstitucion, NombreProyecto, IntencionEducativa, ObjetivoProyecto, Actividad, " +
       "CRN, NumALumnos, AreasDiciplina, Encargado, IdProyecto)" + " VALUES (" + idAdministrador +
       " , " + idUsuario + " , " + institucionNacional + " , " + nombreInstitucion + " , " +
       nombreProyecto + " , " + intencionEducativa + " , " + objetivoProyecto + " , " + actividad +
       " , " + crn + " , " + numALumnos + " , " + areaDisciplinar + " , " + encargado + " , "
       + idProyecto + " )";
          System.out.println(s);
          stmt.executeUpdate(s);
     } catch (Exception e) { System.out.println ("Cannot update database" + e ); }
   }

   public String getIdAdministrador(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT ID-Administrador FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("ID-Administrador");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra id del administrador"
      + e);}
    return nombre;
   }

   public String getIdUsuario(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT ID-Usuario FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("ID-Usuario");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra id del usuario"
      + e);}
    return nombre;
   }

   public String getInstitucionNacional(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT InstitucionNacional FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("InstitucionNacional");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra la institucion Nacional"
      + e);}
    return nombre;
   }

   public String getNombreInstitucion(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT NombreInstitucion FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("NombreInstitucion");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra el nombre de la institucion"
      + e);}
    return nombre;
   }

   public String getNombreProyecto(String idProyecto) {
     String nombre  = "";
     try {
       stmt.executeQuery ("SELECT NombreProyecto FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("NombreProyecto");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra el nombre del proyecto"
      + e);}
    return nombre;
   }

   public String getIntencionEducativa(String idProyecto) {
     String nombre  = "";
     try {
       stmt.executeQuery ("SELECT IntencionEducativa FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("IntencionEducativa");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra la intencion educativa"
      + e);}
    return nombre;
   }

   public String getObjetivoProyecto(String idProyecto) {
     String nombre  = "";
     try {
       stmt.executeQuery ("SELECT ObjetivoProyecto FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("ObjetivoProyecto");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra el objetivo del proyecto"
      + e);}
    return nombre;
   }

   public String getActividades(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT Actividad FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("Actividad");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra la actividad"
      + e);}
    return nombre;
   }

   public int getCRN(String idProyecto) {
     int num = 0;
     try {
       stmt.executeQuery ("SELECT CRN FROM proyecto WHERE idProyecto = " + idProyecto);
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       num = rs.getInt("CRN");
       rs.close();
       return(num);
     } catch (SQLException e) {System.out.println ("No encuentra el CRN"
      + e);}
    return num;
   }

   public int getNumAlumnosIn(String idProyecto) {
     int num = 0;
     try {
       stmt.executeQuery ("SELECT NumALumnos FROM proyecto WHERE idProyecto = " + idProyecto);
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       num = rs.getInt("NumALumnos");
       rs.close();
       return(num);
     } catch (SQLException e) {System.out.println ("No encuentra el numero de alumnos"
      + e);}
    return num;
   }

   public int getAreasDiciplinar(String idProyecto) {
     int num = 0;
     try {
       stmt.executeQuery ("SELECT AreasDiciplina FROM proyecto WHERE idProyecto = " +idProyecto);
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       num = rs.getInt("AreasDiciplina");
       rs.close();
       return(num);
     } catch (SQLException e) {System.out.println ("No encuentra el area diciplinar"
      + e);}
    return num;
   }

   public String getEncargado(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT Encargado FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("Encargado");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra el encargado"
      + e);}
    return nombre;
   }

   public String getIdProyecto(String idProyecto) {
     String nombre = "";
     try {
       stmt.executeQuery ("SELECT ID-Proyecto FROM proyecto WHERE idProyecto = '" +idProyecto + "'");
       ResultSet rs = stmt.getResultSet();
       rs.next(); //Va al registro ya validado
       nombre = rs.getString("ID-Proyecto");
       rs.close();
       return(nombre);
     } catch (SQLException e) {System.out.println ("No encuentra el id del proyecto"
      + e);}
    return nombre;
   }

   public void setInstitucionNacional(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET InstitucionNacional = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute institucionNacional()" + e);}
   }

   public void setNombreInstitucion(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET NombreInstitucion = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute nombreInstitucion()" + e);}
   }

   public void setNombreProyecto(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET NombreProyecto = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute nombreProyecto()" + e);}
   }

   public void setIntencionEducativa(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET IntencionEducativa = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute IntencionEducativa()" + e);}
   }

   public void setObjetivoProyecto(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET ObjetivoProyecto = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute objetivoProyecto()" + e);}
   }

   public void setActividades(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET Actividad = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute actividad()" + e);}
   }

   public void setCRN(String idProyecto, int extra){
      try {
         String s = "UPDATE proyecto SET NombreInstitucion = " + extra + " WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute CRN()" + e);}
   }

   public void setNumAlumnosIn(String idProyecto, int extra){
      try {
         String s = "UPDATE proyecto SET NumALumnos = " + extra + " WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute NumALumnos()" + e);}
   }

   public void setAreasDiciplinar(String idProyecto, int extra){
      try {
         String s = "UPDATE proyecto SET AreasDiciplina = " + extra + " WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute areasDiciplinar()" + e);}
   }

   public void setEncargado(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET Encargado = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute encargado()" + e);}
   }

   public void setIdProyecto(String idProyecto, String extra){
      try {
         String s = "UPDATE proyecto SET NombreInstitucion = '" + extra + "' WHERE ID-Proyecto = '" + idProyecto + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute idProyecto()" + e);}
   }

}
