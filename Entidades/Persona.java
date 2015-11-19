
import java.sql.*;
import java.io.*;

public class Persona{
	private String IDPersona;
	private String Nombre;
	private String ApellidoMaterno;
	private String ApellidoPaterno;
	private int Edad;

	Connection conn;
	Statement stmt;


	//Constructores
	public Persona(){
		 try {
			 String userName = "root";
			 String password = "";
			 String url = "jdbc:mysql://localhost/vinculacion";
			 Class.forName ("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection (url, userName, password);
			 stmt = conn.createStatement();
		 }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
	}

	public boolean validar(String id){
		 try {
				stmt.executeQuery ("SELECT ID-Persona FROM Persona WHERE ID-Persona = '" + id + "'");
				ResultSet rs = stmt.getResultSet();
				if (rs.next()) { //Va al primer registro si lo hay
					 String idPersona = rs.getString("ID-Persona");
					 rs.close();
					 return( id == idPersona );
				}else{ return false;}
		 } catch (SQLException e) {}
		 return false;
	}

	public void agregar(String id, String nombre, String apellidoPat, String apellidoMat, int edad){
		 try {
				String s = "INSERT INTO Persona (ID-Persona, Nombre, ApellidoMaterno, ApellidoPaterno, Edad)" +
									" VALUES ('"+ id + "' , '" + nombre + "', '" + apellidoPat + "', '" + apellidoMat + "', " + edad + " )";
				System.out.println(s);
				stmt.executeUpdate(s);
		 }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
	}

	//Getteres

	public String getIDPersona(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT ID-Persona FROM Persona WHERE ID-Persona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getString("ID-Persona");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getIDPersona()" + e);}
		return temporal;
 	}


	public String getNombre(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT Nombre FROM Persona WHERE ID-Persona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getString("Nombre");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getNombre()" + e);}
		return temporal;
	}

	public String getApellidoMaterno(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT ApellidoMaterno FROM Persona WHERE ID-Persona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getString("ApellidoMaterno");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getApellidoMaterno()" + e);}
		return temporal;
	}

	public String getApellidoPaterno(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT ApellidoPaterno FROM Persona WHERE ID-Persona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getString("ApellidoPaterno");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getApellidoPaterno()" + e);}
		return temporal;
	}

	public int getEdad(String id){
		int temporal = 0;
		try {
			 stmt.executeQuery ("SELECT Edad FROM Persona WHERE ID-Persona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getInt("Edad");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getEdad()" + e);}
		return temporal;
	}

	//Setters

	public void setNombre(String id, String nom){
		try {
			 String s = "UPDATE Persona SET Nombre = '" + nom + "' WHERE ID-Persona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setApellidoMaterno(String id, String am){
		try {
			 String s = "UPDATE Persona SET Nombre = '" + am + "' WHERE ID-Persona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setApellidoPaterno(String id, String ap){
		try {
			 String s = "UPDATE Persona SET Nombre = '" + ap + "' WHERE ID-Persona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setEdad(String id, int ed){
		try {
			 String s = "UPDATE Persona SET Nombre = " + ed + " WHERE ID-Persona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

}
