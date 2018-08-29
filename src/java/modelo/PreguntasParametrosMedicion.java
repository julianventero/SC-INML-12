/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "preguntas_parametros_medicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntasParametrosMedicion.findAll", query = "SELECT p FROM PreguntasParametrosMedicion p")
    , @NamedQuery(name = "PreguntasParametrosMedicion.findByIdPREGUNTASPARAMETROSMEDICION", query = "SELECT p FROM PreguntasParametrosMedicion p WHERE p.idPREGUNTASPARAMETROSMEDICION = :idPREGUNTASPARAMETROSMEDICION")})
public class PreguntasParametrosMedicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPREGUNTAS_PARAMETROS_MEDICION")
    private Integer idPREGUNTASPARAMETROSMEDICION;
    @JoinColumn(name = "PARAMETROS_MEDICION_idPARAMETROS_MEDICION", referencedColumnName = "idPARAMETROS_MEDICION")
    @ManyToOne(optional = false)
    private ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION;
    @JoinColumn(name = "PREGUNTAS_idPREGUNTAS", referencedColumnName = "idPREGUNTAS")
    @ManyToOne(optional = false)
    private Preguntas pREGUNTASidPREGUNTAS;

    public PreguntasParametrosMedicion() {
    }

    public PreguntasParametrosMedicion(Integer idPREGUNTASPARAMETROSMEDICION) {
        this.idPREGUNTASPARAMETROSMEDICION = idPREGUNTASPARAMETROSMEDICION;
    }

    public Integer getIdPREGUNTASPARAMETROSMEDICION() {
        return idPREGUNTASPARAMETROSMEDICION;
    }

    public void setIdPREGUNTASPARAMETROSMEDICION(Integer idPREGUNTASPARAMETROSMEDICION) {
        this.idPREGUNTASPARAMETROSMEDICION = idPREGUNTASPARAMETROSMEDICION;
    }

    public ParametrosMedicion getPARAMETROSMEDICIONidPARAMETROSMEDICION() {
        return pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    public void setPARAMETROSMEDICIONidPARAMETROSMEDICION(ParametrosMedicion pARAMETROSMEDICIONidPARAMETROSMEDICION) {
        this.pARAMETROSMEDICIONidPARAMETROSMEDICION = pARAMETROSMEDICIONidPARAMETROSMEDICION;
    }

    public Preguntas getPREGUNTASidPREGUNTAS() {
        return pREGUNTASidPREGUNTAS;
    }

    public void setPREGUNTASidPREGUNTAS(Preguntas pREGUNTASidPREGUNTAS) {
        this.pREGUNTASidPREGUNTAS = pREGUNTASidPREGUNTAS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPREGUNTASPARAMETROSMEDICION != null ? idPREGUNTASPARAMETROSMEDICION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntasParametrosMedicion)) {
            return false;
        }
        PreguntasParametrosMedicion other = (PreguntasParametrosMedicion) object;
        if ((this.idPREGUNTASPARAMETROSMEDICION == null && other.idPREGUNTASPARAMETROSMEDICION != null) || (this.idPREGUNTASPARAMETROSMEDICION != null && !this.idPREGUNTASPARAMETROSMEDICION.equals(other.idPREGUNTASPARAMETROSMEDICION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PreguntasParametrosMedicion[ idPREGUNTASPARAMETROSMEDICION=" + idPREGUNTASPARAMETROSMEDICION + " ]";
    }
    
}
