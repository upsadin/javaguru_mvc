package by.javaguru;

import by.javaguru.dao.UserDao;
import by.javaguru.entity.User;

import java.util.Optional;

public class UserService {
    private final UserDao userDao = new UserDao();

    private static UserService INSTANCE;

    public static UserService getINSTANCE() {
        if(INSTANCE == null) {
            INSTANCE = new UserService();
        }
        return INSTANCE;
    }

 /*   public Optional<UserDto> getUser(int id) {
        return userDao.findbyId(id).map(it -> new UserDto(it.getName()));
    }*/

    public Optional<User> getUser(int id) {
        return userDao.findbyId(id);
    }


    public Optional<User> findbyLoginAndPwd(String login, String pwd) {
        return userDao.findbyLoginAndPwd(login, pwd);
    }

    public Optional<User> findbyLogin(String login) {
        return userDao.findbyLogin(login);
    }


    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
