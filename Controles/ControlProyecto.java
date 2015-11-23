package controles;
import entidades.Proyecto;

public class ControlProyecto {
  Proyecto proyecto;
  /*private String institucionNacional;
  private String nombreInstitucion;
  private String nombreProyecto;
  private String intencionEducativa;
  private String objetivoProyecto;
  private String actividades;
  private int CRN;
  private int numAlumnosIn;
  private int areasDiciplinar;
  private String encargado;
  private String idProyecto;*/


    public ControlProyecto() {
      proyecto = new Proyecto();
    /*  institucionNacional = "None";
      nombreInstitucion = "None";
      nombreProyecto = "None";
      intencionEducativa = "None";
      objetivoProyecto = "None";
      actividades =  "None";
      CRN = 0;
      numAlumnosIn = 0;
      areasDiciplinar = 0;
      encargado = "None";
      idProyecto = "None";*/
    }

    public void agregarProy (String strAdmin, String strUsu, String strIns, String strNomInst, String strNomPro, String strInt, String strObj, String strAct, int intC, int intNumAl, int intAreas, String strEnc, String strId) {
      proyecto.agregarProyecto(strAdmin, strUsu, strIns, strNomInst, strNomPro, strInt, strObj, strAct, intC, intNumAl, intAreas, strEnc, strId);
    }

    public boolean validarProyecto(String idPro) {
      return proyecto.validarProyecto(idPro);
    }

    public String getIdAdmin(String idPro) {
      return proyecto.getIdAdministrador(idPro);
    }

    public String getIdUsu(String idPro) {
      return proyecto.getIdUsuario(idPro);
    }

    public String getInstitucionNacional(String idPro) {
      return proyecto.getInstitucionNacional(idPro);
    }

    public String getNombreInstitucion(String idPro) {
      return proyecto.getNombreInstitucion(idPro);
    }

    public String getNombreProyecto(String idPro) {
      return proyecto.getNombreProyecto(idPro);
    }

    public String getIntencionEducativa(String idPro) {
      return proyecto.getIntencionEducativa(idPro);
    }

    public String getObjetivoProy(String idPro) {
      return proyecto.getObjetivoProyecto(idPro);
    }

    public String getActividades(String idPro) {
      return proyecto.getActividades(idPro);
    }

    public int getCRN(String idPro) {
      return proyecto.getCRN(idPro);
    }

    public int getNumAlumnosIn(String idPro) {
      return proyecto.getNumAlumnosIn(idPro);
    }

    public int getAreasDiciplinar(String idPro) {
      return proyecto.getAreasDiciplinar(idPro);
    }

    public String getEncargado(String idPro) {
      return proyecto.getEncargado(idPro);
    }

    public String getIdProyecto(String idPro) {
      return proyecto.getIdProyecto(idPro);
    }
    /*
    public void setInstitucionNacional(String idPro, String strIns) {
      proyecto.setInstitucionNacional(idPro, strIns);
    }
    public void setNombreInstitucion (String idPro, String strNomInst) {
      proyecto.setNombreInstitucion(idPro, strNomInst);
    }

    public void setNombreProyecto (String idPro, String strNomPro) {
      proyecto.setNombreProyecto(idPro, strNomPro);
    }

    public void setIntencionEducativa (String idPro, String strInt) {
      proyecto.setIntencionEducativa(idPro, strInt);
    }

    public void setObjetivoProyecto (String idPro, String strObj) {
      proyecto.setObjetivoProyecto(idPro, strObj);
    }

    public void setActividades (String idPro, String strAct) {
      proyecto.setActividades(idPro, strAct);
    }

    public void setCRN (String idPro, int intC) {
      proyecto.setCRN(idPro, intC);
    }

    public void setNumAlumnosIn (String idPro, int intNumAl) {
      proyecto.setNumAlumnosIn(idPro, intNumAl);
    }

    public void setAreasDiciplinar (String idPro, int intAreas) {
      proyecto.setAreasDiciplinar(idPro, intAreas);
    }

    public void setEncargado (String idPro, String strEnc) {
      proyecto.setEncargado(idPro, strEnc);
    }

    public void setIdProyecto (String idPro, String strId) {
      proyecto.setIdProyecto(idPro, strId);
    }
    */

}
