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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdROL", query = "SELECT r FROM Rol r WHERE r.idROL = :idROL")
    , @NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Rol.findByPermiso1", query = "SELECT r FROM Rol r WHERE r.permiso1 = :permiso1")
    , @NamedQuery(name = "Rol.findByPermiso2", query = "SELECT r FROM Rol r WHERE r.permiso2 = :permiso2")
    , @NamedQuery(name = "Rol.findByPermiso3", query = "SELECT r FROM Rol r WHERE r.permiso3 = :permiso3")
    , @NamedQuery(name = "Rol.findByPermiso4", query = "SELECT r FROM Rol r WHERE r.permiso4 = :permiso4")
    , @NamedQuery(name = "Rol.findByPermiso5", query = "SELECT r FROM Rol r WHERE r.permiso5 = :permiso5")
    , @NamedQuery(name = "Rol.findByPermiso6", query = "SELECT r FROM Rol r WHERE r.permiso6 = :permiso6")
    , @NamedQuery(name = "Rol.findByPermiso7", query = "SELECT r FROM Rol r WHERE r.permiso7 = :permiso7")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idROL")
    private Integer idROL;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "Permiso1")
    private Short permiso1;
    @Column(name = "Permiso2")
    private Short permiso2;
    @Column(name = "Permiso3")
    private Short permiso3;
    @Column(name = "Permiso4")
    private Short permiso4;
    @Column(name = "Permiso5")
    private Short permiso5;
    @Column(name = "Permiso6")
    private Short permiso6;
    @Column(name = "Permiso7")
    private Short permiso7;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rOLidROL")
    private List<Usuario> usuarioList;

    public Rol() {
    }

    public Rol(Integer idROL) {
        this.idROL = idROL;
    }

    public Integer getIdROL() {
        return idROL;
    }

    public void setIdROL(Integer idROL) {
        this.idROL = idROL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getPermiso1() {
        return permiso1;
    }

    public void setPermiso1(Short permiso1) {
        this.permiso1 = permiso1;
    }

    public Short getPermiso2() {
        return permiso2;
    }

    public void setPermiso2(Short permiso2) {
        this.permiso2 = permiso2;
    }

    public Short getPermiso3() {
        return permiso3;
    }

    public void setPermiso3(Short permiso3) {
        this.permiso3 = permiso3;
    }

    public Short getPermiso4() {
        return permiso4;
    }

    public void setPermiso4(Short permiso4) {
        this.permiso4 = permiso4;
    }

    public Short getPermiso5() {
        return permiso5;
    }

    public void setPermiso5(Short permiso5) {
        this.permiso5 = permiso5;
    }

    public Short getPermiso6() {
        return permiso6;
    }

    public void setPermiso6(Short permiso6) {
        this.permiso6 = permiso6;
    }

    public Short getPermiso7() {
        return permiso7;
    }

    public void setPermiso7(Short permiso7) {
        this.permiso7 = permiso7;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idROL != null ? idROL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idROL == null && other.idROL != null) || (this.idROL != null && !this.idROL.equals(other.idROL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
