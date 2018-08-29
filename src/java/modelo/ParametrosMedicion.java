/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "parametros_medicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametrosMedicion.findAll", query = "SELECT p FROM ParametrosMedicion p")
    , @NamedQuery(name = "ParametrosMedicion.findByIdPARAMETROSMEDICION", query = "SELECT p FROM ParametrosMedicion p WHERE p.idPARAMETROSMEDICION = :idPARAMETROSMEDICION")
    , @NamedQuery(name = "ParametrosMedicion.findByNombre", query = "SELECT p FROM ParametrosMedicion p WHERE p.nombre = :nombre")})
public class ParametrosMedicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPARAMETROS_MEDICION")
    private Integer idPARAMETROSMEDICION;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pARAMETROSMEDICIONidPARAMETROSMEDICION")
    private List<PreguntasParametrosMedicion> preguntasParametrosMedicionList;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @OneToMany(mappedBy = "pARAMETROSMEDICIONidPARAMETROSMEDICION")
    private List<Respuesta> respuestaList;

    public ParametrosMedicion() {
    }

    public ParametrosMedicion(Integer idPARAMETROSMEDICION) {
        this.idPARAMETROSMEDICION = idPARAMETROSMEDICION;
    }

    public Integer getIdPARAMETROSMEDICION() {
        return idPARAMETROSMEDICION;
    }

    public void setIdPARAMETROSMEDICION(Integer idPARAMETROSMEDICION) {
        this.idPARAMETROSMEDICION = idPARAMETROSMEDICION;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<PreguntasParametrosMedicion> getPreguntasParametrosMedicionList() {
        return preguntasParametrosMedicionList;
    }

    public void setPreguntasParametrosMedicionList(List<PreguntasParametrosMedicion> preguntasParametrosMedicionList) {
        this.preguntasParametrosMedicionList = preguntasParametrosMedicionList;
    }

    public Estado getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(Estado eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPARAMETROSMEDICION != null ? idPARAMETROSMEDICION.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametrosMedicion)) {
            return false;
        }
        ParametrosMedicion other = (ParametrosMedicion) object;
        if ((this.idPARAMETROSMEDICION == null && other.idPARAMETROSMEDICION != null) || (this.idPARAMETROSMEDICION != null && !this.idPARAMETROSMEDICION.equals(other.idPARAMETROSMEDICION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ParametrosMedicion[ idPARAMETROSMEDICION=" + idPARAMETROSMEDICION + " ]";
    }
    
}
