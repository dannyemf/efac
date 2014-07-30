/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dannysoft.uc;

import com.dannysoft.srv.UserService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //request.login("","");
        /*try {
             String password = "admin";
            MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            String encodedPasswordHash = new sun.misc.BASE64Encoder().encode(passwordDigest);
            System.out.println(encodedPasswordHash);
        } catch (Exception e) {
            System.out.println(e);
        }*/

        return bean.count();
        

    }
    
}
