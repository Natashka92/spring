package com.common.dao.user;


import com.common.model.user.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void create(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User update(User user){
        sessionFactory.getCurrentSession().merge(user);
        return user;
    }

    @SuppressWarnings("unchecked")
	public List<User> getList() {
        return sessionFactory.getCurrentSession().getNamedQuery(User.NamedQuery.USER_FIND_ALL).list();
    }

    public void delete(Long id) {
        User user = getById(id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
    
    public User getById(Long id){
        Query query = sessionFactory.getCurrentSession().getNamedQuery(User.NamedQuery.USER_FIND_BY_ID);
        query.setLong("id", id);
        return (User) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
	public List<User> getByName(String name){
        Query query = sessionFactory.getCurrentSession().getNamedQuery(User.NamedQuery.USER_FIND_BY_NAME);
        query.setString("name", name);
        return (List<User>) query.list();
    }

    public User getByLogin(String login){
        Query query = sessionFactory.getCurrentSession().getNamedQuery(User.NamedQuery.USER_FIND_BY_LOGIN);
        query.setString("login", login);
        return (User) query.uniqueResult();
    }
}