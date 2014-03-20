package com.common.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;


public class SecurityUserDetails implements UserDetails{

    private Long id;
    private String userName;
    private String password;

    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private Collection<GrantedAuthority> authorities;

    public SecurityUserDetails() {
        this.id = null;
        this.userName = null;
        this.password = null;
        accountNonLocked = true;
        accountNonExpired = true;
        credentialsNonExpired = true;
        authorities = new HashSet<GrantedAuthority>();
    }

    @Override
    public String toString() {
        return "SecurityUserDetails{" + "id=" + getId() + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void addAuthorities(GrantedAuthority authorities) {
        this.authorities.add(authorities);
    }

    @Override
    public boolean isEnabled() {
        return    isAccountNonExpired() && isAccountNonLocked();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || !(o instanceof  SecurityUserDetails)) { return false; }

        SecurityUserDetails that = (SecurityUserDetails) o;

        if ((userName != null) && (!userName.equals(that.getUsername()))){return false; }
        if ((userName == null) && (that.getUsername() != null)) { return false; }

        if ((password != null) && (!password.equals(that.getPassword()))) { return false; }
        if ((password == null) && (that.getPassword() != null )) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
