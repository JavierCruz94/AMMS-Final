package controles;
public class ControlUbicacionGeografica{
	private String Calle;
	private String Numero;
	private String Colonia;
	private String Estado;
	private String Ciudad;
	private String IDUbicaccion;

	public ControlUbicacionGeografica(){
		Calle = "None";
		Numero = "None";
		Colonia = "None";
		Estado = "None";
		Ciudad = "None";
		IDUbicaccion = "None";
	}

	public ControlUbicacionGeografica(String Call, String Num, String Col,
		String Est, String Ciud, String IDUbicac){
		Calle = Call;
		Numero = Num;
		Colonia = Col;
		Estado = Est;
		Ciudad = Ciud;
		IDUbicaccion = IDUbicac;
	}

	public String getCalle(){
		return Calle;
	}

	public String getNumero(){
		return Numero;
	}

	public String getColonia(){
		return Colonia;
	}

	public String getEstado(){
		return Estado;
	}

	public String getCiudad(){
		return Ciudad;
	}

	public void setCalle(String calle){
		Calle = calle;
	}

	public void setNumero(String Num){
		Numero = Num;
	}

	public void setColonia(String Col){
		Colonia = Col;
	}

	public void setEstado(String Est){
		Estado = Est;
	}

	public void setCiudad(String Ciud){
		Ciudad = Ciud;
	}

}
