package controles;
public class ControlProyecto {
  private String institucionNacional;
  private String nombreInstitucion;
  private String nombreProyecto;
  private String intencionEducativa;
  private String objetivoProyecto;
  private String actividades;
  private int CRN;
  private int numAlumnosIn;
  private int areasDiciplinar;
  private String encargado;
  private String idProyecto;


    public ControlProyecto() {
      institucionNacional = "None";
      nombreInstitucion = "None";
      nombreProyecto = "None";
      intencionEducativa = "None";
      objetivoProyecto = "None";
      actividades =  "None";
      CRN = 0;
      numAlumnosIn = 0;
      areasDiciplinar = 0;
      encargado = "None";
      idProyecto = "None";
    }

    public ControlProyecto(String strIns, String strNomInst, String strNomPro, String strInt,
      String strObj, String strAct, int intC, int intNumAl, int intAreas,
      String strEnc, String strId) {
        institucionNacional = strIns;
        nombreInstitucion = strNomInst;
        nombreProyecto = strNomPro;
        intencionEducativa = strInt;
        objetivoProyecto = strObj;
        actividades = strAct;
        CRN = intC;
        numAlumnosIn = intNumAl;
        areasDiciplinar = intAreas;
        encargado = strEnc;
        idProyecto = strId;
    }

    public String getInstitucionNacional() {
      return institucionNacional;
    }

    public String getNombreInstitucion() {
      return nombreInstitucion;
    }

    public String getNombreProyecto() {
      return nombreProyecto;
    }

    public String getIntencionEducativa() {
      return intencionEducativa;
    }

    public String getObjetivoProyecto() {
      return objetivoProyecto;
    }

    public String getActividades() {
      return actividades;
    }

    public int getCRN() {
      return CRN;
    }

    public int getNumAlumnosIn() {
      return numAlumnosIn;
    }

    public int getAreasDiciplinar() {
      return areasDiciplinar;
    }

    public String getEncargado() {
      return encargado;
    }

    public String getIdProyecto() {
      return idProyecto;
    }

    public void setInstitucionNacional(String strIns) {
      institucionNacional = strIns;
    }
    public void setNombreInstitucion (String strNomInst) {
      nombreInstitucion = strNomInst;
    }

    public void setNombreProyecto (String strNomPro) {
      nombreProyecto = strNomPro;
    }

    public void setIntencionEducativa (String strInt) {
      intencionEducativa = strInt;
    }

    public void setObjetivoProyecto (String strObj) {
      objetivoProyecto = strObj;
    }

    public void setActividades (String strAct) {
      actividades = strAct;
    }

    public void setCRN (int intC) {
      CRN = intC;
    }

    public void setNumAlumnosIn (int intNumAl) {
      numAlumnosIn = intNumAl;
    }

    public void setAreasDiciplinar (int intAreas) {
      areasDiciplinar = intAreas;
    }

    public void setEncargado (String strEnc) {
      encargado = strEnc;
    }

    public void setIdProyecto (String strId) {
      idProyecto = strId;
    }

}
