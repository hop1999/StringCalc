package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

// Hope dies last

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User showUserById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void saveUser(User user) {
        em.persist(user);
    }

    @Transactional
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = em.find(User.class, id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    public void deleteUserById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }
}