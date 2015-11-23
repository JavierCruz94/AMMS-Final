package entidades;
import java.sql.*;
import java.io.*;

public class Persona{
	private String IDPersona = "DEFAULT";
	private String Nombre;
	private String ApellidoMaterno;
	private String ApellidoPaterno;
	private int Edad;
	String idEntrante = "DEFAULT";
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

	public boolean validarPersona(String idE){
		try {
			stmt = conn.createStatement();
			 stmt.executeQuery ("SELECT IdPersona FROM persona WHERE `IdPersona` = \'"+ idE + "\'");
			 ResultSet rs = stmt.getResultSet();
			 if (rs.next()) { //Va al primer registro si lo hay
					idEntrante= rs.getString ("IdPersona");
					rs.close();
					return(true);
			 }
		} catch (SQLException e) {

			System.out.println("Entró al catch de la tabla persona");
		}
		return false;
	}

	public void agregar(String id, String nombre, String apellidoPat, String apellidoMat, int edad){
		 try {
				String s = "INSERT INTO Persona (IdPersona, Nombre, ApellidoMaterno, ApellidoPaterno, Edad)" +
									" VALUES ('"+ id + "' , '" + nombre + "', '" + apellidoPat + "', '" + apellidoMat + "', " + edad + " )";
				System.out.println(s);
				stmt.executeUpdate(s);
		 }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
	}

	//Getteres

	public String getIDPersona(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT IdPersona FROM Persona WHERE IdPersona = '" + id + "'");
			 ResultSet rs = stmt.getResultSet();
			 rs.next(); //Va al registro ya validado
			 temporal = rs.getString("IdPersona");
			 rs.close();
			 return(temporal);
		} catch (SQLException e) {System.out.println ("Cannot getIDPersona()" + e);}
		return temporal;
 	}


	public String getNombre(String id){
		String temporal = "";
		try {
			 stmt.executeQuery ("SELECT Nombre FROM Persona WHERE IdPersona = '" + id + "'");
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
			 stmt.executeQuery ("SELECT ApellidoMaterno FROM Persona WHERE IdPersona = '" + id + "'");
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
			 stmt.executeQuery ("SELECT ApellidoPaterno FROM Persona WHERE IdPersona = '" + id + "'");
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
			 stmt.executeQuery ("SELECT Edad FROM Persona WHERE IdPersona = '" + id + "'");
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
			 String s = "UPDATE Persona SET Nombre = '" + nom + "' WHERE IdPersona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setApellidoMaterno(String id, String am){
		try {
			 String s = "UPDATE Persona SET Nombre = '" + am + "' WHERE IdPersona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setApellidoPaterno(String id, String ap){
		try {
			 String s = "UPDATE Persona SET Nombre = '" + ap + "' WHERE IdPersona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

	public void setEdad(String id, int ed){
		try {
			 String s = "UPDATE Persona SET Nombre = " + ed + " WHERE IdPersona = '" + id + "'";
			 stmt.executeUpdate(s);
		} catch (SQLException e) {System.out.println ("Cannot execute setNombre()" + e);}
	}

}
