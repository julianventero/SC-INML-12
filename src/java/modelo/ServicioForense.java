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
@Table(name = "servicio_forense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioForense.findAll", query = "SELECT s FROM ServicioForense s")
    , @NamedQuery(name = "ServicioForense.findByIdSERVICIOFORENSE", query = "SELECT s FROM ServicioForense s WHERE s.idSERVICIOFORENSE = :idSERVICIOFORENSE")
    , @NamedQuery(name = "ServicioForense.findByNombre", query = "SELECT s FROM ServicioForense s WHERE s.nombre = :nombre")})
public class ServicioForense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSERVICIO_FORENSE")
    private Integer idSERVICIOFORENSE;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sERVICIOFORENSEidSERVICIOFORENSE")
    private List<Encuesta> encuestaList;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @JoinColumn(name = "GRUPO_idGRUPO", referencedColumnName = "idGRUPO")
    @ManyToOne(optional = false)
    private Grupo gRUPOidGRUPO;

    public ServicioForense() {
    }

    public ServicioForense(Integer idSERVICIOFORENSE) {
        this.idSERVICIOFORENSE = idSERVICIOFORENSE;
    }

    public Integer getIdSERVICIOFORENSE() {
        return idSERVICIOFORENSE;
    }

    public void setIdSERVICIOFORENSE(Integer idSERVICIOFORENSE) {
        this.idSERVICIOFORENSE = idSERVICIOFORENSE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    public Estado getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(Estado eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    public Grupo getGRUPOidGRUPO() {
        return gRUPOidGRUPO;
    }

    public void setGRUPOidGRUPO(Grupo gRUPOidGRUPO) {
        this.gRUPOidGRUPO = gRUPOidGRUPO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSERVICIOFORENSE != null ? idSERVICIOFORENSE.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioForense)) {
            return false;
        }
        ServicioForense other = (ServicioForense) object;
        if ((this.idSERVICIOFORENSE == null && other.idSERVICIOFORENSE != null) || (this.idSERVICIOFORENSE != null && !this.idSERVICIOFORENSE.equals(other.idSERVICIOFORENSE))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
