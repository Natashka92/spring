package com.common.services.user;

import com.common.dto.OutputListDTO;
import com.common.dto.user.UserInputDTO;
import com.common.dto.user.UserOutputDTO;
import com.common.dto.user.UserRegisterDTO;
import com.common.exception.position.PositionNotFoundException;
import com.common.exception.user.UserLoginAlreadyExistsException;
import com.common.exception.user.UserNotFoundException;
import com.common.exception.user.UserPasswordNotEqualsException;

public interface UserLightWeighService {

    /**
     * Find all users
     * @return  {@link OutputListDTO<UserOutputDTO>}
     * @throws UserNotFoundException
     */
    OutputListDTO<UserOutputDTO> findAll()
        throws
            UserNotFoundException;

    /**
     * Find user by id
     * @param id - id of chosen user
     * @return  {@link UserOutputDTO}
     * @throws UserNotFoundException
     */
    UserOutputDTO findById(final Long id)
        throws
            UserNotFoundException;

    /**
     * Create User object in the system
     * @param userDTO
     * @return {@link UserInputDTO}
     * @throws UserLoginAlreadyExistsException
     * @throws UserPasswordNotEqualsException
     */
    UserOutputDTO create(UserInputDTO userDTO)
        throws
            UserLoginAlreadyExistsException,
            UserPasswordNotEqualsException;

    /**
     * Update User object in the system
     * @param id - user id
     * @param userDTO - DTO with description for the user being updated
     * @throws UserNotFoundException
     * @throws PositionNotFoundException
     */
    void update(Long id, UserInputDTO userDTO)
        throws
            PositionNotFoundException;

    /**
     * Delete user from system
     * @param id - id of chosen user
     * @throws UserNotFoundException
     */
    void delete(Long id)
        throws
            UserNotFoundException;

}
