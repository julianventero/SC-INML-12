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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "muestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Muestra.findAll", query = "SELECT m FROM Muestra m")
    , @NamedQuery(name = "Muestra.findByIdMUESTRA", query = "SELECT m FROM Muestra m WHERE m.idMUESTRA = :idMUESTRA")
    , @NamedQuery(name = "Muestra.findByPlaneada", query = "SELECT m FROM Muestra m WHERE m.planeada = :planeada")
    , @NamedQuery(name = "Muestra.findByFechaMuestra", query = "SELECT m FROM Muestra m WHERE m.fechaMuestra = :fechaMuestra")})
public class Muestra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMUESTRA")
    private Integer idMUESTRA;
    @Column(name = "planeada")
    private Integer planeada;
    @Column(name = "fecha_muestra")
    @Temporal(TemporalType.DATE)
    private Date fechaMuestra;
    @JoinColumn(name = "ENCUESTA_idENCUESTA", referencedColumnName = "idENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta eNCUESTAidENCUESTA;

    public Muestra() {
    }

    public Muestra(Integer idMUESTRA) {
        this.idMUESTRA = idMUESTRA;
    }

    public Integer getIdMUESTRA() {
        return idMUESTRA;
    }

    public void setIdMUESTRA(Integer idMUESTRA) {
        this.idMUESTRA = idMUESTRA;
    }

    public Integer getPlaneada() {
        return planeada;
    }

    public void setPlaneada(Integer planeada) {
        this.planeada = planeada;
    }

    public Date getFechaMuestra() {
        return fechaMuestra;
    }

    public void setFechaMuestra(Date fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public Encuesta getENCUESTAidENCUESTA() {
        return eNCUESTAidENCUESTA;
    }

    public void setENCUESTAidENCUESTA(Encuesta eNCUESTAidENCUESTA) {
        this.eNCUESTAidENCUESTA = eNCUESTAidENCUESTA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMUESTRA != null ? idMUESTRA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muestra)) {
            return false;
        }
        Muestra other = (Muestra) object;
        if ((this.idMUESTRA == null && other.idMUESTRA != null) || (this.idMUESTRA != null && !this.idMUESTRA.equals(other.idMUESTRA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Muestra[ idMUESTRA=" + idMUESTRA + " ]";
    }
    
}
