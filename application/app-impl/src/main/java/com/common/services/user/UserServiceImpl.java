package com.common.services.user;

import com.common.dao.role.RoleDAO;
import com.common.dao.user.UserDAO;
import com.common.data.Authorities;
import com.common.dto.user.UserRegisterDTO;
import com.common.exception.AppExceptionFactory;
import com.common.exception.position.PositionNotFoundException;
import com.common.exception.user.UserLoginAlreadyExistsException;
import com.common.exception.user.UserNotFoundException;
import com.common.exception.user.UserPasswordNotEqualsException;
import com.common.model.role.Role;
import com.common.model.user.User;
import java.util.ArrayList;
import java.util.List;

import com.common.services.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AppExceptionFactory appExceptionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User create(User user)
        throws
            UserLoginAlreadyExistsException,
            UserPasswordNotEqualsException {
        if(userDAO.getByLogin(user.getLogin()) != null){
            throw appExceptionFactory.getAppException(UserLoginAlreadyExistsException.class);
        }
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        Long id = new Long(Authorities.ROLE_USER.getId());
        role = roleDAO.findById(id);
        roles.add(role);
        user.setRoles(roles);

        user.setPassword(passwordEncoder.encodePassword(user.getPassword(),null));

        userDAO.create(user);
        return user;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(User user)
        throws
            PositionNotFoundException{
        userDAO.update(user);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<User> getList()
        throws
            UserNotFoundException{
        List<User> users = userDAO.getList();
        if(users == null){
            throw appExceptionFactory.getAppException(UserNotFoundException.class);
        }
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id)
        throws
            UserNotFoundException {
        if(userDAO.getById(id) == null){
            throw appExceptionFactory.getAppException(UserNotFoundException.class);
        }
        userDAO.delete(id);
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User getById(Long id)
        throws
            UserNotFoundException{
        User user = userDAO.getById(id);
        if(user == null) {
            throw appExceptionFactory.getAppException(UserNotFoundException.class);
        }
        return user;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<User> getByName(String name)
        throws
            UserNotFoundException {
        List<User> users = userDAO.getByName(name);
        if(users == null) {
             throw appExceptionFactory.getAppException(UserNotFoundException.class);
        }
    	return users;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User getByLogin(String login)
            throws
            UserNotFoundException{
        User user = userDAO.getByLogin(login);
        if(user == null){
            throw appExceptionFactory.getAppException(UserNotFoundException.class);
        }
        return user;
    }
}