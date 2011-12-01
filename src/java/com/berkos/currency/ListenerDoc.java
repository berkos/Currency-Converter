/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.berkos.currency;

import javax.servlet.*;



/**
 *
 * @author BerkosDesk
 */
public class ListenerDoc implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet1.");
       // System.out.println("hiii");
        ServletContext sc=  sce.getServletContext();
        String sourceB =sc.getInitParameter("source");
       // System.out.println(sourceB);
        Doc docc = new Doc(sourceB);
        sc.setAttribute("doccc", docc);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet2.");
    }
    
}
