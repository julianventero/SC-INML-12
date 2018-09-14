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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "encuesta_preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaPreguntas.findAll", query = "SELECT e FROM EncuestaPreguntas e")
    , @NamedQuery(name = "EncuestaPreguntas.findByIdENCUESTAPREGUNTAS", query = "SELECT e FROM EncuestaPreguntas e WHERE e.idENCUESTAPREGUNTAS = :idENCUESTAPREGUNTAS")})
public class EncuestaPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA_PREGUNTAS")
    private Integer idENCUESTAPREGUNTAS;
    @JoinColumn(name = "ENCUESTA_idENCUESTA", referencedColumnName = "idENCUESTA")
    @ManyToOne(optional = false)
    private Encuesta eNCUESTAidENCUESTA;
    @JoinColumn(name = "PREGUNTAS_idPREGUNTAS", referencedColumnName = "idPREGUNTAS")
    @ManyToOne(optional = false)
    private Preguntas pREGUNTASidPREGUNTAS;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAPREGUNTASidENCUESTAPREGUNTAS")
    private List<Respuesta> respuestaList;

    public EncuestaPreguntas() {
    }

    public EncuestaPreguntas(Integer idENCUESTAPREGUNTAS) {
        this.idENCUESTAPREGUNTAS = idENCUESTAPREGUNTAS;
    }

    public Integer getIdENCUESTAPREGUNTAS() {
        return idENCUESTAPREGUNTAS;
    }

    public void setIdENCUESTAPREGUNTAS(Integer idENCUESTAPREGUNTAS) {
        this.idENCUESTAPREGUNTAS = idENCUESTAPREGUNTAS;
    }

    public Encuesta getENCUESTAidENCUESTA() {
        return eNCUESTAidENCUESTA;
    }

    public void setENCUESTAidENCUESTA(Encuesta eNCUESTAidENCUESTA) {
        this.eNCUESTAidENCUESTA = eNCUESTAidENCUESTA;
    }

    public Preguntas getPREGUNTASidPREGUNTAS() {
        return pREGUNTASidPREGUNTAS;
    }

    public void setPREGUNTASidPREGUNTAS(Preguntas pREGUNTASidPREGUNTAS) {
        this.pREGUNTASidPREGUNTAS = pREGUNTASidPREGUNTAS;
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
        hash += (idENCUESTAPREGUNTAS != null ? idENCUESTAPREGUNTAS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaPreguntas)) {
            return false;
        }
        EncuestaPreguntas other = (EncuestaPreguntas) object;
        if ((this.idENCUESTAPREGUNTAS == null && other.idENCUESTAPREGUNTAS != null) || (this.idENCUESTAPREGUNTAS != null && !this.idENCUESTAPREGUNTAS.equals(other.idENCUESTAPREGUNTAS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idENCUESTAPREGUNTAS.toString();
    }
    
}
