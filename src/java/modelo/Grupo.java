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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author julia
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
    , @NamedQuery(name = "Grupo.findByIdGRUPO", query = "SELECT g FROM Grupo g WHERE g.idGRUPO = :idGRUPO")
    , @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGRUPO")
    private Integer idGRUPO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gRUPOidGRUPO")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gRUPOidGRUPO")
    private List<ServicioForense> servicioForenseList;

    public Grupo() {
    }

    public Grupo(Integer idGRUPO) {
        this.idGRUPO = idGRUPO;
    }

    public Grupo(Integer idGRUPO, String nombre) {
        this.idGRUPO = idGRUPO;
        this.nombre = nombre;
    }

    public Integer getIdGRUPO() {
        return idGRUPO;
    }

    public void setIdGRUPO(Integer idGRUPO) {
        this.idGRUPO = idGRUPO;
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

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<ServicioForense> getServicioForenseList() {
        return servicioForenseList;
    }

    public void setServicioForenseList(List<ServicioForense> servicioForenseList) {
        this.servicioForenseList = servicioForenseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGRUPO != null ? idGRUPO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGRUPO == null && other.idGRUPO != null) || (this.idGRUPO != null && !this.idGRUPO.equals(other.idGRUPO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
