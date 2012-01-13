package org.jboss.seam.spring.example.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.seam.spring.example.domain.User;
import org.jboss.seam.spring.example.domain.UserDao;

/**
 * @author Marius Bogoevici
 */
@Named
public class Invoker {
    @Inject
    UserDao userDao;
    
    public String getMessage(String username) {
       User user = userDao.getForUsername(username);
       return "CDI greets " + user.getFirstName() + " " + user.getLastName();
    }
}
