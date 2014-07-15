/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dannysoft;

import com.dannysoft.srv.UserService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author uti
 */

@Named
@RequestScoped
public class UserList {
    
    @EJB
    UserService  bean;
    
    public long getCount(){
        return bean.count();
    }
    
}
