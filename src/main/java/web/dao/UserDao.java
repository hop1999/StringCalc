package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User showUserById(int id);

    void saveUser(User user);

    void updateUserById(int id, User updatedUser);

    void deleteUserById(int id);

}
