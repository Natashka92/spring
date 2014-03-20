package com.common.model.user;

import com.common.model.IdentifierEntity;
import javax.persistence.*;
import java.util.List;
import com.common.model.role.Role;

@NamedQueries({
		@NamedQuery(name = User.NamedQuery.USER_FIND_ALL, query = "from User"),
		@NamedQuery(name = User.NamedQuery.USER_FIND_BY_ID, query = "from User where id = :id"),
        @NamedQuery(name = User.NamedQuery.USER_FIND_BY_LOGIN, query = "from User where login=:login"),
        @NamedQuery(name = User.NamedQuery.USER_FIND_BY_NAME, query = "from User where firstName=:name")
})



@Entity
@Table(name = "user")
public class User extends IdentifierEntity {

    @Column(name = "login", length = 45, nullable = false, unique = true)
    private String login;

    @Column(name="password", nullable = false)
    private String password;

	@Column(name = "firstName")
	private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "userid")}, inverseJoinColumns = {@JoinColumn(name = "roleid")} )
    private List<Role> roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public static class NamedQuery {
		public static final String USER_FIND_ALL = "User.findAll";
		public static final String USER_FIND_BY_ID = "User.findById";
		public static final String USER_FIND_BY_NAME = "User.findByName";
        public static final String USER_FIND_BY_LOGIN = "User.findByLogin";
	}
}