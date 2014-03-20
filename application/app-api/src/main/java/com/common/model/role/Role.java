package com.common.model.role;

import com.common.model.IdentifierEntity;
import com.common.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@NamedQueries({ @NamedQuery(name = Role.NamedQuery.ROLE_FIND_ALL, query = "FROM Role") })
public class Role extends IdentifierEntity{

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<User> users;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class NamedQuery {
        public static final String ROLE_FIND_ALL = "Role.findAll";
    }
}
