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
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e")
    , @NamedQuery(name = "Encuesta.findByIdENCUESTA", query = "SELECT e FROM Encuesta e WHERE e.idENCUESTA = :idENCUESTA")
    , @NamedQuery(name = "Encuesta.findByNombre", query = "SELECT e FROM Encuesta e WHERE e.nombre = :nombre")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENCUESTA")
    private Integer idENCUESTA;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @JoinColumn(name = "SERVICIO_FORENSE_idSERVICIO_FORENSE", referencedColumnName = "idSERVICIO_FORENSE")
    @ManyToOne(optional = false)
    private ServicioForense sERVICIOFORENSEidSERVICIOFORENSE;
    @JoinColumn(name = "USUARIO_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario uSUARIOcedula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<EncuestaPreguntas> encuestaPreguntasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNCUESTAidENCUESTA")
    private List<Muestra> muestraList;

    public Encuesta() {
    }

    public Encuesta(Integer idENCUESTA) {
        this.idENCUESTA = idENCUESTA;
    }

    public Integer getIdENCUESTA() {
        return idENCUESTA;
    }

    public void setIdENCUESTA(Integer idENCUESTA) {
        this.idENCUESTA = idENCUESTA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(Estado eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    public ServicioForense getSERVICIOFORENSEidSERVICIOFORENSE() {
        return sERVICIOFORENSEidSERVICIOFORENSE;
    }

    public void setSERVICIOFORENSEidSERVICIOFORENSE(ServicioForense sERVICIOFORENSEidSERVICIOFORENSE) {
        this.sERVICIOFORENSEidSERVICIOFORENSE = sERVICIOFORENSEidSERVICIOFORENSE;
    }

    public Usuario getUSUARIOcedula() {
        return uSUARIOcedula;
    }

    public void setUSUARIOcedula(Usuario uSUARIOcedula) {
        this.uSUARIOcedula = uSUARIOcedula;
    }

    @XmlTransient
    public List<EncuestaPreguntas> getEncuestaPreguntasList() {
        return encuestaPreguntasList;
    }

    public void setEncuestaPreguntasList(List<EncuestaPreguntas> encuestaPreguntasList) {
        this.encuestaPreguntasList = encuestaPreguntasList;
    }

    @XmlTransient
    public List<Muestra> getMuestraList() {
        return muestraList;
    }

    public void setMuestraList(List<Muestra> muestraList) {
        this.muestraList = muestraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idENCUESTA != null ? idENCUESTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idENCUESTA == null && other.idENCUESTA != null) || (this.idENCUESTA != null && !this.idENCUESTA.equals(other.idENCUESTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
