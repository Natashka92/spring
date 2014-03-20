package com.common.services.role;

import com.common.exception.role.RoleNotFoundException;
import com.common.model.role.Role;
import java.util.List;

public interface RoleService {

    /**
     * Find all roles
     * @return {@link List<Role>}
     */
    public List<Role> findAll()
            throws RoleNotFoundException;

    /**
     * Find Role by Id
     * @param id - id of role
     * @return {@link Role}
     */
    Role findById(Long id)
            throws RoleNotFoundException;

    /**
     * Create string from List of Role
     * @param roles - List of roles
     * @return String
     */
    String createString(List<Role> roles);
}
