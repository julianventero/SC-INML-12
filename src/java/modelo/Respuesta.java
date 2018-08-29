/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findByIdRESPUESTA", query = "SELECT r FROM Respuesta r WHERE r.idRESPUESTA = :idRESPUESTA")
    , @NamedQuery(name = "Respuesta.findByRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuesta = :respuesta")
    , @NamedQuery(name = "Respuesta.findByFechaRealizacion", query = "SELECT r FROM Respuesta r WHERE r.fechaRealizacion = :fechaRealizacion")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRESPUESTA")
    private Integer idRESPUESTA;
    @Size(max = 255)
    @Column(name = "respuesta")
    private String respuesta;
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    @JoinColumn(name = "CLIENTE_idCLIENTE", referencedColumnName = "idCLIENTE")
    @ManyToOne(optional = false)
    private Cliente cLIENTEidCLIENTE;
    @JoinColumn(name = "ENCUESTA_PREGUNTAS_idENCUESTA_PREGUNTAS", referencedColumnName = "idENCUESTA_PREGUNTAS")
    @ManyToOne(optional = false)
    private EncuestaPreguntas eNCUESTAPREGUNTASidENCUESTAPREGUNTAS;
    @JoinColumn(name = "PARAMETROS_MEDICION_idPARAMETROS_MEDICION", referencedColumnName = "idPARAMETROS_MEDICION")
    @ManyToOne
    private ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION;
    @JoinColumn(name = "SECCIONAL_idSECCIONAL", referencedColumnName = "idSECCIONAL")
    @ManyToOne(optional = false)
    private Seccional sECCIONALidSECCIONAL;

    public Respuesta() {
    }

    public Respuesta(Integer idRESPUESTA) {
        this.idRESPUESTA = idRESPUESTA;
    }

    public Integer getIdRESPUESTA() {
        return idRESPUESTA;
    }

    public void setIdRESPUESTA(Integer idRESPUESTA) {
        this.idRESPUESTA = idRESPUESTA;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Cliente getCLIENTEidCLIENTE() {
        return cLIENTEidCLIENTE;
    }

    public void setCLIENTEidCLIENTE(Cliente cLIENTEidCLIENTE) {
        this.cLIENTEidCLIENTE = cLIENTEidCLIENTE;
    }

    public EncuestaPreguntas getENCUESTAPREGUNTASidENCUESTAPREGUNTAS() {
        return eNCUESTAPREGUNTASidENCUESTAPREGUNTAS;
    }

    public void setENCUESTAPREGUNTASidENCUESTAPREGUNTAS(EncuestaPreguntas eNCUESTAPREGUNTASidENCUESTAPREGUNTAS) {
        this.eNCUESTAPREGUNTASidENCUESTAPREGUNTAS = eNCUESTAPREGUNTASidENCUESTAPREGUNTAS;
    }

    public ParametrosMedicion getPARAMETROSMEDICIONidPARAMETROSMEDICION() {
        return pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    public void setPARAMETROSMEDICIONidPARAMETROSMEDICION(ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION) {
        this.pARAMETROSMEDICIONidPARAMETROSMEDICION = pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    public Seccional getSECCIONALidSECCIONAL() {
        return sECCIONALidSECCIONAL;
    }

    public void setSECCIONALidSECCIONAL(Seccional sECCIONALidSECCIONAL) {
        this.sECCIONALidSECCIONAL = sECCIONALidSECCIONAL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRESPUESTA != null ? idRESPUESTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRESPUESTA == null && other.idRESPUESTA != null) || (this.idRESPUESTA != null && !this.idRESPUESTA.equals(other.idRESPUESTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Respuesta[ idRESPUESTA=" + idRESPUESTA + " ]";
    }
    
}
