package com.common.services.user;

import com.common.dto.user.UserRegisterDTO;
import com.common.exception.position.PositionNotFoundException;
import com.common.exception.user.UserLoginAlreadyExistsException;
import com.common.exception.user.UserNotFoundException;
import com.common.exception.user.UserPasswordNotEqualsException;
import com.common.model.user.User;
import java.util.List;

public interface UserService {

    /**
     * Add new user in system
     * @param user- new instance of user
     * @return  {@link }
     */
	public User create(User user)
        throws
            UserLoginAlreadyExistsException,
            UserPasswordNotEqualsException;

    /**
     * Update user in system
     * @param user  - updated user
     */
    public void update(User user)
        throws
            PositionNotFoundException;

    /**
     * Find all users
     * @return  {@link List<User>}
     * @throws UserNotFoundException
     */
    public List<User> getList()
        throws
            UserNotFoundException;

    /**
     * Delete user from system
     * @param id - id of chosen user
     * @throws UserNotFoundException
     */
	public void delete(Long id)
        throws
            UserNotFoundException;

    /**
     * Find user by id
     * @param id - id of chosen user
     * @return {@link User}
     * @throws UserNotFoundException
     */
	public User getById(Long id)
        throws
            UserNotFoundException;

    /**
     * Find users by first name
     * @param name - first name of chosen users
     * @return {@link List<User>}
     * @throws UserNotFoundException
     */
	public List<User> getByName(String name)
        throws
            UserNotFoundException;

    /**
     * Find user by login
     * @param login - login of chosen user
     * @return {@link User}
     * @throws UserNotFoundException
     */
    public User getByLogin(String login)
        throws
            UserNotFoundException;

}