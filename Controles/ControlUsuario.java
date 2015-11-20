package controles;
import entidades.Usuario;

public class ControlUsuario extends ControlPersona{
	private boolean Privilegio;
	private String IDUsuario;
	private String Contrasena;
	Usuario usuario;



	public ControlUsuario(){
		Privilegio = false;
		IDUsuario = "None";
		Contrasena = "None";
		usuario = new Usuario();
	}

	public ControlUsuario(String IDPer, String Nom, String ApellidoMat,
		String ApellidoPat, int Ed, boolean Pr, String IDUsu,
		String Cont, Usuario usu){
		Privilegio = Pr;
		IDUsuario = IDUsu;
		Contrasena = Cont;
		usuario = usu;
	}

	public boolean getPrivilegio(){
		return Privilegio;
	}

	public String getIDUsuario(){
		return IDUsuario;
	}

	public String getContrasena(){
		return Contrasena;
	}


	public void setPrivilegio(boolean Privi){
		Privilegio = Privi;
	}

	public void setIDUsuario(String IDUsu){
		IDUsuario = IDUsu;
	}

	public void setContrasena(String Cont){
		Contrasena = Cont;
	}

	public boolean validarIDUsuario(String id){
      return(usuario.validarUsuario(id));
   }
}
