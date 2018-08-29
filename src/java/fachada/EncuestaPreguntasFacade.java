/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EncuestaPreguntas;

/**
 *
 * @author julia
 */
@Stateless
public class EncuestaPreguntasFacade extends AbstractFacade<EncuestaPreguntas> {

    @PersistenceContext(unitName = "SC-INML-12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaPreguntasFacade() {
        super(EncuestaPreguntas.class);
    }
    
}
