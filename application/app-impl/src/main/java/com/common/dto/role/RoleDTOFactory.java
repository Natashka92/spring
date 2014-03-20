package com.common.dto.role;


import com.common.dto.GenericDTOFactory;
import com.common.dto.OutputListDTO;
import com.common.model.role.Role;
import org.springframework.stereotype.Component;


@Component
public class RoleDTOFactory extends GenericDTOFactory<Role, RoleInputDTO, RoleOutputDTO, OutputListDTO<RoleOutputDTO>>{

    @Override
    public RoleOutputDTO createOutputDTO(Role role){
        RoleOutputDTO dto = null;
        if(role != null){
            dto = new RoleOutputDTO();
            dto.setName(role.getName());
            dto.setId(role.getId());
        }
        return dto;
    }

    @Override
    protected RoleInputDTO getInputDTO() {
        return new RoleInputDTO();
    }

    @Override
    protected RoleOutputDTO getOutputDTO(){
        return new RoleOutputDTO();
    }

    @Override
    protected OutputListDTO<RoleOutputDTO> getNewListDTO() {
        return new OutputListDTO<RoleOutputDTO>();
    }
}
