package pe.egcc.eurekaapp.model;

import java.util.Date;

/**
 *
 * @author Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class Tsession {

  private int id;
  private String codemp;
  private String equipo;
  private Date fecini;
  private Date fecfin;
  private int estado;

  public Tsession() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCodemp() {
    return codemp;
  }

  public void setCodemp(String codemp) {
    this.codemp = codemp;
  }

  public String getEquipo() {
    return equipo;
  }

  public void setEquipo(String equipo) {
    this.equipo = equipo;
  }

  public Date getFecini() {
    return fecini;
  }

  public void setFecini(Date fecini) {
    this.fecini = fecini;
  }

  public Date getFecfin() {
    return fecfin;
  }

  public void setFecfin(Date fecfin) {
    this.fecfin = fecfin;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

}
