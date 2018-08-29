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
@Table(name = "aspecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspecto.findAll", query = "SELECT a FROM Aspecto a")
    , @NamedQuery(name = "Aspecto.findByIdASPECTO", query = "SELECT a FROM Aspecto a WHERE a.idASPECTO = :idASPECTO")
    , @NamedQuery(name = "Aspecto.findByNombre", query = "SELECT a FROM Aspecto a WHERE a.nombre = :nombre")})
public class Aspecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idASPECTO")
    private Integer idASPECTO;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "CRITERIO_idCRITERIO", referencedColumnName = "idCRITERIO")
    @ManyToOne(optional = false)
    private Criterio cRITERIOidCRITERIO;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aSPECTOidASPECTO")
    private List<Preguntas> preguntasList;

    public Aspecto() {
    }

    public Aspecto(Integer idASPECTO) {
        this.idASPECTO = idASPECTO;
    }

    public Integer getIdASPECTO() {
        return idASPECTO;
    }

    public void setIdASPECTO(Integer idASPECTO) {
        this.idASPECTO = idASPECTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Criterio getCRITERIOidCRITERIO() {
        return cRITERIOidCRITERIO;
    }

    public void setCRITERIOidCRITERIO(Criterio cRITERIOidCRITERIO) {
        this.cRITERIOidCRITERIO = cRITERIOidCRITERIO;
    }

    public Estado getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(Estado eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    @XmlTransient
    public List<Preguntas> getPreguntasList() {
        return preguntasList;
    }

    public void setPreguntasList(List<Preguntas> preguntasList) {
        this.preguntasList = preguntasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idASPECTO != null ? idASPECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspecto)) {
            return false;
        }
        Aspecto other = (Aspecto) object;
        if ((this.idASPECTO == null && other.idASPECTO != null) || (this.idASPECTO != null && !this.idASPECTO.equals(other.idASPECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
