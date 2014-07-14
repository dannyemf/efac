/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dannysoft;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class UserBean {

    public int count() {
        return 950;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
