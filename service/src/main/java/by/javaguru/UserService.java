package by.javaguru;

import by.javaguru.dao.UserDao;
import by.javaguru.entity.User;

import java.util.Optional;

public class UserService {
    private final UserDao userDao = new UserDao();

 /*   public Optional<UserDto> getUser(int id) {
        return userDao.findbyId(id).map(it -> new UserDto(it.getName()));
    }*/

    public Optional<User> getUser(int id) {
        return userDao.findbyId(id);
    }

    public Optional<User> findbyLoginAndPwd(String login, String pwd) {
        return userDao.findbyLoginAndPwd(login, pwd);
    }
}
