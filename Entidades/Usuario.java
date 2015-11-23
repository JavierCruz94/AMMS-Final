package entidades;
import java.sql.*;
import java.io.*;
import controles.*;

public class Usuario  {
   Connection conn;
   Statement stmt;
   String idEntrante = "DEFAULT";
   int privi = 0;
  // String idP,idU,;

   public Usuario(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/vinculacion";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }

   public boolean validarUsuario(String idE){
      try {
        stmt = conn.createStatement();
         stmt.executeQuery ("SELECT `ID-Usuario` FROM usuario WHERE `ID-Usuario` = \'"+ idE+ "\'");
         ResultSet rs = stmt.getResultSet();
         if (rs.next()) { //Va al primer registro si lo hay
            idEntrante= rs.getString ("ID-Usuario");
            rs.close();
            return(true);
         }
      } catch (SQLException e) {

        System.out.println("Entró al catch de la tabla usuario");
      }
      return false;
   }

   public boolean getPrivi(String idE){
     try {
        stmt.executeQuery ("SELECT Privilegio FROM usuario WHERE `ID-Usuario` =  \'"+ idE + "\'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        privi = rs.getInt("Privilegio");
        rs.close();
        if(privi == 1){
            return(true);
        }
        return false;
     } catch (SQLException e) {System.out.println ("Cannot getPrivi()" + e);}
     return false;
   }

   public void agregarUsuario(String idP, String idU, String idA, String contraU, int privi){
      try {
         String s = "INSERT INTO USUARIO (`ID-Persona`,`ID-Usuario`, ContrasenaU, Privilegio,`ID-Administrador`)" +
                   " VALUES ('"+ idP + "' , '" + idU + "', '" + contraU + "', " + privi + ", '" + idA + "' )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
   }
/*

   public void setContraU(String IDU ,String ContraU){
      try {
         String s = "UPDATE usuario SET ContrasenaU = '" + ContraU + "' WHERE usuario = '"+ IDU + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
   }

   public void setPrivilegio(String IDU ,String privi){
      try {
         String s = "UPDATE usuario SET Privilegio = '"+ privi + "' WHERE usuario = '"+ IDU+"'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
   }

   public String getPrivi(String IDU){
     String privi = "";
     try {
        stmt.executeQuery ("SELECT Privilegio FROM usuario WHERE ID-Usuario =  '"+ IDU+"'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        privi = rs.getString("Privilegio");
        rs.close();
        return(privi);
     } catch (SQLException e) {System.out.println ("Cannot getPrivi()" + e);}
     return privi;
   }

   public String getContraU(String IDU){
     String contraUsu = "";
     try {
        stmt.executeQuery ("SELECT ContrasenaU FROM usuario WHERE ID-Usuario = '"+ IDU+"'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        contraUsu = rs.getString("ContrasenaU");
        rs.close();
        return(contraUsu);
     } catch (SQLException e) {System.out.println ("Cannot getContraU()" + e);}
     return contraUsu;
   }

   public String getAdmin(String IDU){
     String  IDA ="";
     try {
        stmt.executeQuery ("SELECT ID-Administrador FROM usuario WHERE ID-Usuario ='"+ IDU+"'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        IDA = rs.getString("ID-Administrador");
        rs.close();
        return(IDA);
     } catch (SQLException e) {System.out.println ("Cannot getPrivi()" + e);}
     return IDA;
   }
*/
}
