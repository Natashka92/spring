package com.common.services.role;

import com.common.dto.OutputListDTO;
import com.common.dto.role.RoleOutputDTO;
import java.util.List;

public interface RoleLightWeightService {

    /**
     * Find all roles
     * @return {@link List<RoleOutputDTO>}
     */
    public OutputListDTO<RoleOutputDTO> findAll();

}
