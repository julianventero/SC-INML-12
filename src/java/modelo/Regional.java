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
@Table(name = "regional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regional.findAll", query = "SELECT r FROM Regional r")
    , @NamedQuery(name = "Regional.findByIdREGIONAL", query = "SELECT r FROM Regional r WHERE r.idREGIONAL = :idREGIONAL")
    , @NamedQuery(name = "Regional.findByNombre", query = "SELECT r FROM Regional r WHERE r.nombre = :nombre")})
public class Regional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idREGIONAL")
    private Integer idREGIONAL;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rEGIONALidREGIONAL")
    private List<Seccional> seccionalList;

    public Regional() {
    }

    public Regional(Integer idREGIONAL) {
        this.idREGIONAL = idREGIONAL;
    }

    public Integer getIdREGIONAL() {
        return idREGIONAL;
    }

    public void setIdREGIONAL(Integer idREGIONAL) {
        this.idREGIONAL = idREGIONAL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Seccional> getSeccionalList() {
        return seccionalList;
    }

    public void setSeccionalList(List<Seccional> seccionalList) {
        this.seccionalList = seccionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idREGIONAL != null ? idREGIONAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regional)) {
            return false;
        }
        Regional other = (Regional) object;
        if ((this.idREGIONAL == null && other.idREGIONAL != null) || (this.idREGIONAL != null && !this.idREGIONAL.equals(other.idREGIONAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
