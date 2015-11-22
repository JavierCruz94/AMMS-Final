package controles;
import entidades.Administrador;

public class ControlAdministrador extends ControlPersona {
	private String IDAdministrador;
	private String ContrasenaAD;
	Administrador admin;

	public ControlAdministrador(){
		IDAdministrador = "None";
		ContrasenaAD = "None";
		admin = new Administrador();
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
	public boolean validarIDAdministrador(String id){
			return(admin.validarAdmin(id));
	 }
}
