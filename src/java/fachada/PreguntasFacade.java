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
import modelo.Preguntas;

/**
 *
 * @author julia
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> {

    @PersistenceContext(unitName = "SC-INML-12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasFacade() {
        super(Preguntas.class);
    }
        
    public List<Preguntas> verPreguntas2(int servicio){
    return em.createNativeQuery("select * from preguntas where idPREGUNTAS =?1", Preguntas.class).setParameter(1,servicio).getResultList();
    }
}
