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

	public boolean getPrivilegio(String id){
		return(usuario.getPrivi(id));
	}

	public String getIDUsuario(){
		return IDUsuario;
	}

	public String getContrasena(){
		return Contrasena;
	}


	public void setPrivilegio(String cuenta,int privi){
		usuario.setPrivilegio(cuenta,privi);
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

	 public void agregarUsuarioDB(String idP, String idU, String idA, String contraU, int privi){
		 usuario.agregarUsuario(idP,idU,idA,contraU,privi);
	 }
}
