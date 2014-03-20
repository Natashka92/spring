package com.common.dao.user;

import com.common.model.user.User;
import java.util.List;

public interface UserDAO {

    /**
     * Add new user in system
     *
     * @param user - new instance of user
     */
    public void create(User user);

    /**
     * Update user in system
     * @param user  - updated user
     * @return  {@link User}
     */
    public User update(User user);

    /**
     * Find all users
     * @return  List<User>
     */
    public List<User> getList();

    /**
     * Delete user from system
     * @param id - id of chosen user
     */
    public void delete(Long id);

    /**
     * Find user by id
     * @param id - id of chosen user
     * @return User
     */
    public User getById(Long id);

    /**
     * Find users by FirstName
     * @param name  - First Name of chosen user
     * @return   List<User>
     */
    public List<User> getByName(String name);

    /**
     * find user by login
     * @param login - login of user
     * @return  {@link User}
     */
    public User getByLogin(String login);
}