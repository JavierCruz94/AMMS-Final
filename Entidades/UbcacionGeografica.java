package entidades;
import java.sql.*;
import java.io.*;

public class UbcacionGeografica{
   Connection conn;
   Statement stmt;

   public UbcacionGeografica(){
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/vinculacion";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }

   public boolean validar(String IDUbicacion){
      try {
         stmt.executeQuery ("SELECT ID-Ubicacion FROM geografica WHERE ID-Ubicacion = '" + IDUbicacion + "'");
         ResultSet rs = stmt.getResultSet();
         if (rs.next()) { //Va al primer registro si lo hay
            String Ubicacion = rs.getString ("ID-Ubicacion");
            rs.close();
            return( IDUbicacion == Ubicacion );
         }else{ return false;}
      } catch (SQLException e) {}
      return false;
   }

   public void agregar(String Calle, int Numero, String Colonia,String Estado,
    String Ciudad, String IDUbicaccion){
      try {
         String s = "INSERT INTO GEOGRAFICA (Calle, Numero, Colonia, Estado, Ciudad, IDUbicaccion)" +
                   " VALUES ("+ Calle + " , " + Numero + ", " + Colonia +
                    "', " + Estado + " , '" + Ciudad + "', " + IDUbicaccion + " )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
   }

   public void setCalle(String IDUbicacion, String Calle){
      try {
         String s = "UPDATE geografica SET Calle = '" + Calle + "'' WHERE ID-Ubicacion = '" + Calle + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute Calle()" + e);}
   }

   public void setNumero(String IDUbicacion, String Numero){
      try {
         String s = "UPDATE geografica SET Numero = " + Numero + " WHERE Numero = " + Numero;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute Numero()" + e);}
   }

    public void setColonia(String IDUbicacion, String Colonia){
      try {
         String s = "UPDATE geografica SET Colonia = '" + Colonia + "'' WHERE Colonia = '" + Colonia + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute Colonia()" + e);}
   }

    public void setEstado(String IDUbicacion, String Estado){
      try {
         String s = "UPDATE geografica SET Estado = '" + Estado + "'' WHERE Estado = '" + Estado + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute Estado()" + e);}
   }

    public void setCiudad(String IDUbicacion, String Ciudad){
      try {
         String s = "UPDATE geografica SET Ciudad = '" + Ciudad + "'' WHERE Ciudad = '" + Ciudad + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute Ciudad()" + e);}
   }

    public void setIDUbicaccion(String IDUbicacion, String IDUbicaccion){
      try {
         String s = "UPDATE geografica SET IDUbicaccion = '" + IDUbicaccion + "'' WHERE IDUbicaccion = '" + IDUbicaccion + "'";
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute IDUbicaccion()" + e);}
   }

   public String getCalle(String Calle){
      String calle = "None";
      try {
         stmt.executeQuery ("SELECT Calle FROM geografica WHERE Calle = '" + Calle + "'");
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         calle = rs.getString("Calle");
         rs.close();
         return(calle);
      } catch (SQLException e) {System.out.println ("Cannot getCalle()" + e);}
      return calle;
   }

   public int getNumero(String Numero){
      int numero = 0;
      try {
         stmt.executeQuery ("SELECT Numero FROM geografica WHERE Numero = " + Numero);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         numero = rs.getInt("Numero");
         rs.close();
         return(numero);
      } catch (SQLException e) {System.out.println ("Cannot getNumero()" + e);}
      return numero;
   }

    public String getColonia(String Colonia){
      String colonia = "None";
      try {
         stmt.executeQuery ("SELECT Colonia FROM geografica WHERE Colonia = '" + Colonia + "'");
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         colonia = rs.getString("Colonia");
         rs.close();
         return(colonia);
      } catch (SQLException e) {System.out.println ("Cannot getColonia()" + e);}
      return colonia;
   }

   public String getEstado(String Estado){
      String estado = "None";
      try {
         stmt.executeQuery ("SELECT Estado FROM geografica WHERE Estado = '" + Estado + "'");
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         estado = rs.getString("Colonia");
         rs.close();
         return(estado);
      } catch (SQLException e) {System.out.println ("Cannot getEstado()" + e);}
      return estado;
   }

    public String getCiudad(String Ciudad){
      String ciudad = "None";
      try {
         stmt.executeQuery ("SELECT Ciudad FROM geografica WHERE Ciudad = '" + Ciudad + "'");
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         ciudad = rs.getString("Ciudad");
         rs.close();
         return(ciudad);
      } catch (SQLException e) {System.out.println ("Cannot getCiudad()" + e);}
      return ciudad;
   }

    public String getIDUbicaccion(String IDUbicaccion){
      String idUbicaccion = "None";
      try {
         stmt.executeQuery ("SELECT IDUbicaccion FROM geografica WHERE IDUbicaccion = '" + IDUbicaccion + "'");
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         idUbicaccion = rs.getString("IDUbicaccion");
         rs.close();
         return(idUbicaccion);
      } catch (SQLException e) {System.out.println ("Cannot getIDUbicaccion()" + e);}
      return idUbicaccion;
   }

}
