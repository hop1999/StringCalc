package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {  // Как я понял транзакции обрабатывать тут не надо, они же уже обрабатываются в Dao
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {return userDao.getAllUsers();}

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Override
    public void saveUser(User user) {userDao.saveUser(user);}

    @Override
    public void updateUserById(int id, User updatedUser) {
        userDao.updateUserById(id, updatedUser);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }
}
