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
import javax.persistence.Query;
import modelo.Encuesta;

/**
 *
 * @author julia
 */
@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> {

    @PersistenceContext(unitName = "SC-INML-12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }
    public List<Encuesta> buscarXServicio(String servicio){
    return em.createNativeQuery("select * from encuesta where  servicio_forense_idSERVICIO_FORENSE=?1", Encuesta.class).setParameter(1, servicio).getResultList();
    }
    
}
