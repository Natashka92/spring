package com.common.dao.role;


import com.common.model.role.Role;

import java.util.List;

public interface RoleDAO {

    /**
     * Find all roles
     * @return {@link List<Role>}
     */
    List<Role> findAll();

    /**
     * Find role by id
     * @param id - id of role
     * @return {@link Role}
     */
    Role findById(Long id);
}
