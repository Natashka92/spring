package com.common.services.security;

import com.common.dao.user.UserDAO;
import com.common.data.Authorities;
import com.common.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.common.model.user.User;
import com.common.model.security.SecurityUserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


public class SecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDAO.getByLogin(userName);
        if(user == null){
            throw new UsernameNotFoundException("Error: user with login: " +
                userName +
                "is not exist in system.");
        }
        return prepareUserDetails(user);
    }

    private SecurityUserDetails prepareUserDetails(User user) {

        SecurityUserDetails userDetails = new SecurityUserDetails();
        userDetails.setId(user.getId());
        userDetails.setUsername(user.getLogin());
        userDetails.setPassword(user.getPassword());

        userDetails.setAccountNonLocked(true);
        userDetails.setAccountNonExpired(true);
        userDetails.setCredentialsNonExpired(true);

        List<Role> roleList = user.getRoles();
        if ((roleList == null) || (roleList.isEmpty())){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(Authorities.ROLE_USER.getName());
            userDetails.addAuthorities(grantedAuthority);
        }
        else{
            for (Role role: roleList){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
                userDetails.addAuthorities(grantedAuthority);
            }
        }
        return userDetails;
    }
}
