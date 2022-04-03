package spring_boot.dao;

import spring_boot.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    User getUserById(long id);

}
