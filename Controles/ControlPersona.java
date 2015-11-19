package controles;
public class ControlPersona{
	private String IDPersona;
	private String Nombre;
	private String ApellidoMaterno;
	private String ApellidoPaterno;
	private int Edad;

	public ControlPersona(){
		IDPersona = "None";
		Nombre = "None";
		ApellidoMaterno = "None";
		ApellidoPaterno = "None";
		Edad = 0;
	}

	public ControlPersona(String IDPer, String Nom, String ApellidoMat,
		String ApellidoPat, int Ed){
		IDPersona = IDPer;
		Nombre = Nom;
		ApellidoMaterno = ApellidoMat;
		ApellidoPaterno = ApellidoPat;
		Edad = Ed;
	}

	public String getIDPersona(){
		return IDPersona;
	}

	public String getNombre(){
		return Nombre;
	}

	public String getApellidoMaterno(){
		return ApellidoMaterno;
	}

	public String getApellidoPaterno(){
		return ApellidoPaterno;
	}

	public int getEdad(){
		return Edad;
	}

	public void setIDPersona(String IDPer){
		IDPersona = IDPer;
	}

	public void setNombre(String Nom){
		Nombre = Nom;
	}

	public void setApellidoMaterno(String ApellidoMat){
		ApellidoMaterno = ApellidoMat;
	}

	public void setApellidoPaterno(String ApellidoPat){
		ApellidoPaterno = ApellidoPat;
	}

	public void setEdad(int Ed){
		Edad = Ed;
	}

}
