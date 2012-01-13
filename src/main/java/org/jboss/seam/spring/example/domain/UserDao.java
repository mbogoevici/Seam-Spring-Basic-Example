package org.jboss.seam.spring.example.domain;

import org.jboss.solder.core.Veto;

public interface UserDao {
    User getForUsername(String username);

    void createUser(User user);
}