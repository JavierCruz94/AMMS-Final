package entidades;
import java.sql.*;
import java.io.*;
//import controles.ControlPersona;

public class Administrador  {
   Connection conn;
   Statement stmt;
   String idEntrante = "DEFAULT2";

   public Administrador(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/vinculacion";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }

   public boolean validarAdmin(String idE){

     try {
        stmt = conn.createStatement();
         stmt.executeQuery ("SELECT `ID-Administrador` FROM administrador WHERE `ID-Administrador` = \'"+ idE+ "\'" );
         ResultSet rs = stmt.getResultSet();
         if (rs.next()) { //Va al primer registro si lo hay
            idEntrante= rs.getString ("ID-Administrador");
            rs.close();
            return(true);
         }
      } catch (SQLException e) {

         System.out.println("Entró al catch de la tabla administrador");
       }
       return false;
     }
     /*
   public void agregar(String IDP, String nom, String apeM,String apeP,int edad,String IDA,String ContraU){
      try {
         String s = "INSERT INTO ADMINISTRADOR (ID-Persona,ID-Administrador, ContrasenaU, Privilegio,ID-Administrador)" +
                   " VALUES ("+ IDP + " , '" + IDA + "', " + ContraU + " )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
   }

   public void setContraU(String IDU ,String ContraU){
      try {
         String s = "UPDATE administrador SET ContrasenaU = '" + ContraU + "' WHERE administrador = '"+ IDU + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
   }

   public String getContraU(String IDU){
     String contraUsu = "";
     try {
        stmt.executeQuery ("SELECT ContrasenaU FROM administrador WHERE ID-Administrador = '"+ IDU+"'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        contraUsu = rs.getString("ContrasenaU");
        rs.close();
        return(contraUsu);
     } catch (SQLException e) {System.out.println ("Cannot getContraU()" + e);}
     return contraUsu;
   }

   public String getAdmin(String IDU){
     String  IDA = "";
     try {
        stmt.executeQuery ("SELECT ID-Administrador FROM administrador WHERE ID-Administrador ='"+ IDU+"'");
        ResultSet rs = stmt.getResultSet();
        rs.next(); //Va al registro ya validado
        IDA = rs.getString("ID-Administrador");
        rs.close();
        return(IDA);
     } catch (SQLException e) {System.out.println ("Cannot getPrivi()" + e);}
     return IDA;
   }*/

}
