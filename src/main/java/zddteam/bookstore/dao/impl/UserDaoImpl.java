package zddteam.bookstore.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zddteam.bookstore.dao.UserRepository;
import zddteam.bookstore.domain.User;

@Component
public class UserDaoImpl {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User findUserById(Long id){
        return userRepository.findOne(id);
    }
}
