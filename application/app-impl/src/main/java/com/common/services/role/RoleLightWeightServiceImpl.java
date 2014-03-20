package com.common.services.role;

import com.common.dto.OutputListDTO;
import com.common.dto.role.RoleOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.common.dto.role.RoleDTOFactory;

@Component
public class RoleLightWeightServiceImpl implements  RoleLightWeightService{

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleDTOFactory roleDTOFactory;

    @Override
    public OutputListDTO<RoleOutputDTO> findAll() {
        return roleDTOFactory.createListDTO(roleService.findAll());
    }
}
