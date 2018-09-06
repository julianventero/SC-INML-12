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
import modelo.PreguntasParametrosMedicion;

/**
 *
 * @author julia
 */
@Stateless
public class PreguntasParametrosMedicionFacade extends AbstractFacade<PreguntasParametrosMedicion> {

    @PersistenceContext(unitName = "SC-INML-12PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasParametrosMedicionFacade() {
        super(PreguntasParametrosMedicion.class);
    }
   
}
