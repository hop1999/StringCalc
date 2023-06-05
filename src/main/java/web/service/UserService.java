package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
     List<User> getAllUsers();

     User showUserById(int id);

     void saveUser(User user);

     void updateUserById(int id, User updatedUser);

     void deleteUserById(int id);
}
