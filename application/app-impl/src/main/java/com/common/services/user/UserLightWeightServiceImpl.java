package com.common.services.user;

import com.common.dto.OutputListDTO;
import com.common.dto.user.UserInputDTO;
import com.common.dto.user.UserDTOFactory;
import com.common.dto.user.UserOutputDTO;
import com.common.dto.user.UserRegisterDTO;
import com.common.exception.AppExceptionFactory;
import com.common.exception.position.PositionNotFoundException;
import com.common.exception.user.UserLoginAlreadyExistsException;
import com.common.exception.user.UserNotFoundException;
import com.common.exception.user.UserPasswordNotEqualsException;
import com.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLightWeightServiceImpl implements UserLightWeighService{

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOFactory userDTOFactory;

    @Autowired
    private AppExceptionFactory appExceptionFactory;

    @Override
    public OutputListDTO<UserOutputDTO> findAll()
        throws
            UserNotFoundException {
        return userDTOFactory.createListDTO(userService.getList());
    }

    @Override
    public UserOutputDTO findById(Long id)
        throws
            UserNotFoundException{
        return userDTOFactory.createOutputDTO(userService.getById(id));
    }

    @Override
    public UserOutputDTO create(UserInputDTO userInputDTO)
        throws
            UserLoginAlreadyExistsException,
            UserPasswordNotEqualsException {

        if(!userInputDTO.getPassword().equals(userInputDTO.getConfirmPassword())){
            throw  appExceptionFactory.getAppException(UserPasswordNotEqualsException.class);
        }
        User user = userDTOFactory.initModel(userInputDTO);
        return userDTOFactory.createOutputDTO(userService.create(user));
    }

    @Override
    public void update(Long id, UserInputDTO userDTO)
        throws
            PositionNotFoundException{
        User user = userService.getById(id);
        if(user == null){
            appExceptionFactory.getAppException(PositionNotFoundException.class);
        }
        userDTOFactory.updateModel(user, userDTO);
        userService.update(user);
    }

    @Override
    public void delete(Long id)
        throws
            UserNotFoundException{
        userService.delete(id);
    }
}
