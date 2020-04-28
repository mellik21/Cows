package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;

@Repository
public class UserDao implements Dao<User>{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        return (List<User>)  sessionFactory.getCurrentSession().createQuery("From User").list();
    }

    @Override
    public User get(int id) {
       return  sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void persist(User user) {
        Session session =  sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void update(User user) {
        Session session =  sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void delete(User user) {
        Session session =  sessionFactory.getCurrentSession();
        session.delete(user);
    }

    /**
     * Ищет пользователя в БД, зная его логин и пароль, но не зная id (при авторизации)
     */
    public int find(User user) {
        Session session =  sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM User u where u.login = :login and u.password =:password");
        List result = query
                .setParameter("login", user.getLogin())
                .setParameter("password", user.getPassword())
                .getResultList();

        if (result.size() == 1) {
            return ((User)result.get(0)).getId();
        }else {
            return -1;
        }

    }
}