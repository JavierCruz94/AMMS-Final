package controles;
import entidades.Administrador;

public class ControlAdministrador extends ControlPersona {
	private String IDAdministrador;
	private String ContrasenaAD;

//RAWR tengo mucha hambre
//pruebas raras de eli :D
	public ControlAdministrador(){
		IDAdministrador = "None";
		ContrasenaAD = "None";
	}

	public ControlAdministrador(String IDPer, String Nom, String ApellidoMat,
		String ApellidoPat, int Ed, String IDAd, String ContA){
		IDAdministrador = IDAd;
		ContrasenaAD = ContA;
	}

	public String getIDAdministrador(){
		return IDAdministrador;
	}

	public String getContrasenaAD(){
		return ContrasenaAD;
	}


	public void setIDAdministrador(String IDAdmin){
		IDAdministrador = IDAdmin;
	}

	public void setContrasena(String ContA){
		ContrasenaAD = ContA;
	}
}
