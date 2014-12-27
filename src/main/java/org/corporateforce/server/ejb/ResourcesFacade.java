/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.corporateforce.server.model.Resources;

/**
 *
 * @author Chep
 */
@Stateless
public class ResourcesFacade extends AbstractFacade<Resources> implements ResourcesFacadeLocal {
    @PersistenceContext(unitName = "org.corporateforce_CorporateForce_Server_war_0.0.1-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResourcesFacade() {
        super(Resources.class);
    }
    
}
