/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dannysoft.srv;

import com.dannysoft.rep.UserRepository;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class UserService {
    
    @PersistenceContext(name = "com.dannysoft_efac-ejb_ejb_1.0-SNAPSHOTPU")
    EntityManager em;

    public long count() {        
        return new UserRepository(em).count();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
