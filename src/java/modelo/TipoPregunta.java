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
@Table(name = "tipo_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPregunta.findAll", query = "SELECT t FROM TipoPregunta t")
    , @NamedQuery(name = "TipoPregunta.findByIdTIPOPREGUNTA", query = "SELECT t FROM TipoPregunta t WHERE t.idTIPOPREGUNTA = :idTIPOPREGUNTA")
    , @NamedQuery(name = "TipoPregunta.findByNombre", query = "SELECT t FROM TipoPregunta t WHERE t.nombre = :nombre")})
public class TipoPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO_PREGUNTA")
    private Integer idTIPOPREGUNTA;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tIPOPREGUNTAidTIPOPREGUNTA")
    private List<Preguntas> preguntasList;

    public TipoPregunta() {
    }

    public TipoPregunta(Integer idTIPOPREGUNTA) {
        this.idTIPOPREGUNTA = idTIPOPREGUNTA;
    }

    public Integer getIdTIPOPREGUNTA() {
        return idTIPOPREGUNTA;
    }

    public void setIdTIPOPREGUNTA(Integer idTIPOPREGUNTA) {
        this.idTIPOPREGUNTA = idTIPOPREGUNTA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTIPOPREGUNTA != null ? idTIPOPREGUNTA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPregunta)) {
            return false;
        }
        TipoPregunta other = (TipoPregunta) object;
        if ((this.idTIPOPREGUNTA == null && other.idTIPOPREGUNTA != null) || (this.idTIPOPREGUNTA != null && !this.idTIPOPREGUNTA.equals(other.idTIPOPREGUNTA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
