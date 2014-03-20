package com.common.dao.role;

import com.common.model.role.Role;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> findAll() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Role.findAll");
        return query.list();
    }

    @Override
    public Role findById(Long id) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }
}
