/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.biz;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mark
 */
@Stateless
public class GameLiveFacade extends AbstractFacade<GameLive> {
    @PersistenceContext(unitName = "ages-w007PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameLiveFacade() {
        super(GameLive.class);
    }
    
}
