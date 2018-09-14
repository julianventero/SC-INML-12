/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.ParametrosMedicion;
import modelo.PreguntasParametrosMedicion;

/**
 *
 * @author julia
 */
@Stateless
public class ParametrosMedicionFacade extends AbstractFacade<ParametrosMedicion> {

    @PersistenceContext(unitName = "SC-INML-12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametrosMedicionFacade() {
        super(ParametrosMedicion.class);
    }

    public List<ParametrosMedicion> parametrosXpregunta(String id_pregunta) {
        return em.createNativeQuery("select * from parametros_medicion p inner join preguntas_parametros_medicion pp on p.idPARAMETROS_MEDICION=pp.PARAMETROS_MEDICION_idPARAMETROS_MEDICION where  pp.PREGUNTAS_idPREGUNTAS=?1",ParametrosMedicion.class).setParameter(1, id_pregunta).getResultList();
    }

}
