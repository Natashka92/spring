package com.common.services.role;

import com.common.dao.role.RoleDAO;
import com.common.exception.AppExceptionFactory;
import com.common.exception.role.RoleNotFoundException;
import com.common.model.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements  RoleService{

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AppExceptionFactory appExceptionFactory;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<Role> findAll()
            throws RoleNotFoundException{
        List<Role> roles = roleDAO.findAll();
        if((roles == null) || (roles.isEmpty())){
            throw appExceptionFactory.getAppException(RoleNotFoundException.class);
        }
        return roles;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Role findById(Long id)
            throws RoleNotFoundException{
        Role role = roleDAO.findById(id);
        if(role == null){
            throw appExceptionFactory.getAppException(RoleNotFoundException.class);
        }
        return  role;
    }

    public String createString(List<Role> roles){
        StringBuilder stringBuilder = new StringBuilder();
        for(Role role : roles){
            stringBuilder.append(role.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
