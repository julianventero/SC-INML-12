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
@Table(name = "seccional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccional.findAll", query = "SELECT s FROM Seccional s")
    , @NamedQuery(name = "Seccional.findByIdSECCIONAL", query = "SELECT s FROM Seccional s WHERE s.idSECCIONAL = :idSECCIONAL")
    , @NamedQuery(name = "Seccional.findByNombre", query = "SELECT s FROM Seccional s WHERE s.nombre = :nombre")})
public class Seccional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSECCIONAL")
    private Integer idSECCIONAL;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sECCIONALidSECCIONAL")
    private List<Municipio> municipioList;
    @JoinColumn(name = "REGIONAL_idREGIONAL", referencedColumnName = "idREGIONAL")
    @ManyToOne(optional = false)
    private Regional rEGIONALidREGIONAL;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sECCIONALidSECCIONAL")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sECCIONALidSECCIONAL")
    private List<Respuesta> respuestaList;

    public Seccional() {
    }

    public Seccional(Integer idSECCIONAL) {
        this.idSECCIONAL = idSECCIONAL;
    }

    public Integer getIdSECCIONAL() {
        return idSECCIONAL;
    }

    public void setIdSECCIONAL(Integer idSECCIONAL) {
        this.idSECCIONAL = idSECCIONAL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public Regional getREGIONALidREGIONAL() {
        return rEGIONALidREGIONAL;
    }

    public void setREGIONALidREGIONAL(Regional rEGIONALidREGIONAL) {
        this.rEGIONALidREGIONAL = rEGIONALidREGIONAL;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (idSECCIONAL != null ? idSECCIONAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccional)) {
            return false;
        }
        Seccional other = (Seccional) object;
        if ((this.idSECCIONAL == null && other.idSECCIONAL != null) || (this.idSECCIONAL != null && !this.idSECCIONAL.equals(other.idSECCIONAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
