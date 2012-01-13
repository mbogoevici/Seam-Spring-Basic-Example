package org.jboss.seam.spring.example.domain;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jboss.solder.core.Veto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Veto
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public User getForUsername(String username) {
        try {
            Query query = entityManager
                    .createQuery("select u from User u where u.username = ?");
            query.setParameter(1, username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

}