package by.javaguru;

import by.javaguru.dao.UserDao;
import by.javaguru.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao = new UserDao();
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

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
        Optional<User> user= userDao.findbyLoginAndPwd(login, pwd);
        LOG.warn("Found user{}", user.get());
        return user;

    }

    public Optional<User> findbyLogin(String login) {
        Optional<User> user = userDao.findbyLogin(login);
        LOG.warn("Found user{}", user.get());
        return user;
    }


    public void addUser(User user) {

        userDao.addUser(user);
        LOG.info("user{} is created", user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
        LOG.info("user{} is updated", user);
        LOG.warn("user{} is updated", user);
    }
}
