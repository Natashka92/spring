package com.common.dto.user;

import com.common.dto.GenericDTOFactory;
import com.common.dto.OutputListDTO;
import org.springframework.stereotype.Component;
import com.common.model.user.User;


@Component
public class UserDTOFactory extends GenericDTOFactory<User, UserInputDTO, UserOutputDTO, OutputListDTO<UserOutputDTO>> {

    public User initModel(UserInputDTO dto){
        User user = new User();
        updateModel(user, dto);
        return user;
    }

    @Override
    public UserOutputDTO createOutputDTO(User user){
        UserOutputDTO dto = null;
        if(user != null){
            dto = super.createOutputDTO(user);
            dto.setLogin(user.getLogin());
            dto.setPassword(user.getPassword());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setAddress(user.getAddress());
        }
        return dto;
    }

    public void updateModel(User user, UserInputDTO dto){
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAddress(dto.getAddress());
    }

    @Override
    protected UserInputDTO getInputDTO() {
        return new UserInputDTO();
    }

    @Override
    protected  UserOutputDTO getOutputDTO(){
        return new UserOutputDTO();
    }

    @Override
    protected OutputListDTO<UserOutputDTO> getNewListDTO() {
        return new OutputListDTO<UserOutputDTO>();
    }
}
