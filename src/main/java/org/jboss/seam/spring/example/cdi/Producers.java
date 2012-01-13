package org.jboss.seam.spring.example.cdi;

import javax.enterprise.inject.Produces;

import org.jboss.seam.spring.context.SpringContext;
import org.jboss.seam.spring.context.Web;
import org.jboss.seam.spring.example.domain.UserDao;
import org.jboss.seam.spring.inject.SpringBean;
import org.springframework.context.ApplicationContext;

/**
 * @author Marius Bogoevici
 */
public class Producers {
    
    @Produces @Web @SpringContext
    ApplicationContext context;
    
    @Produces @SpringBean
    UserDao userDao;
}
