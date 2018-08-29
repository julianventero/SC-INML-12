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
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findByIdPREGUNTAS", query = "SELECT p FROM Preguntas p WHERE p.idPREGUNTAS = :idPREGUNTAS")
    , @NamedQuery(name = "Preguntas.findByPregunta", query = "SELECT p FROM Preguntas p WHERE p.pregunta = :pregunta")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPREGUNTAS")
    private Integer idPREGUNTAS;
    @Size(max = 250)
    @Column(name = "pregunta")
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pREGUNTASidPREGUNTAS")
    private List<PreguntasParametrosMedicion> preguntasParametrosMedicionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pREGUNTASidPREGUNTAS")
    private List<EncuestaPreguntas> encuestaPreguntasList;
    @JoinColumn(name = "ASPECTO_idASPECTO", referencedColumnName = "idASPECTO")
    @ManyToOne(optional = false)
    private Aspecto aSPECTOidASPECTO;
    @JoinColumn(name = "ESTADO_idESTADO", referencedColumnName = "idESTADO")
    @ManyToOne(optional = false)
    private Estado eSTADOidESTADO;
    @JoinColumn(name = "TIPO_PREGUNTA_idTIPO_PREGUNTA", referencedColumnName = "idTIPO_PREGUNTA")
    @ManyToOne(optional = false)
    private TipoPregunta tIPOPREGUNTAidTIPOPREGUNTA;

    public Preguntas() {
    }

    public Preguntas(Integer idPREGUNTAS) {
        this.idPREGUNTAS = idPREGUNTAS;
    }

    public Integer getIdPREGUNTAS() {
        return idPREGUNTAS;
    }

    public void setIdPREGUNTAS(Integer idPREGUNTAS) {
        this.idPREGUNTAS = idPREGUNTAS;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @XmlTransient
    public List<PreguntasParametrosMedicion> getPreguntasParametrosMedicionList() {
        return preguntasParametrosMedicionList;
    }

    public void setPreguntasParametrosMedicionList(List<PreguntasParametrosMedicion> preguntasParametrosMedicionList) {
        this.preguntasParametrosMedicionList = preguntasParametrosMedicionList;
    }

    @XmlTransient
    public List<EncuestaPreguntas> getEncuestaPreguntasList() {
        return encuestaPreguntasList;
    }

    public void setEncuestaPreguntasList(List<EncuestaPreguntas> encuestaPreguntasList) {
        this.encuestaPreguntasList = encuestaPreguntasList;
    }

    public Aspecto getASPECTOidASPECTO() {
        return aSPECTOidASPECTO;
    }

    public void setASPECTOidASPECTO(Aspecto aSPECTOidASPECTO) {
        this.aSPECTOidASPECTO = aSPECTOidASPECTO;
    }

    public Estado getESTADOidESTADO() {
        return eSTADOidESTADO;
    }

    public void setESTADOidESTADO(Estado eSTADOidESTADO) {
        this.eSTADOidESTADO = eSTADOidESTADO;
    }

    public TipoPregunta getTIPOPREGUNTAidTIPOPREGUNTA() {
        return tIPOPREGUNTAidTIPOPREGUNTA;
    }

    public void setTIPOPREGUNTAidTIPOPREGUNTA(TipoPregunta tIPOPREGUNTAidTIPOPREGUNTA) {
        this.tIPOPREGUNTAidTIPOPREGUNTA = tIPOPREGUNTAidTIPOPREGUNTA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPREGUNTAS != null ? idPREGUNTAS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idPREGUNTAS == null && other.idPREGUNTAS != null) || (this.idPREGUNTAS != null && !this.idPREGUNTAS.equals(other.idPREGUNTAS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Preguntas[ idPREGUNTAS=" + idPREGUNTAS + " ]";
    }
    
}
