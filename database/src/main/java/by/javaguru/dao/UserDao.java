package by.javaguru.dao;

import by.javaguru.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {
    private final String FIND_BY_ID = """
            SELECT * FROM 
            """;
    int idNum;

    private List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User(idNum++, "Pavel", 37, "u@gmail.com", "pavel", "passp"));
        users.add(new User(idNum++, "Egor", 24, "e@gmail.com", "egor", "passe"));
        users.add(new User(idNum++, "Sveta", 25, "s@gmail.com", "sveta", "passs"));
    }

    public void addUser(User user) {
        user.setId(idNum++);
        users.add(user);
    }
    public Optional<User> findbyId(int id) {
           return users.stream().filter(u -> u.getId()==id).findFirst();
    }

    public List<User> showAll() {
        return users;
    }

    public Optional<User> findbyLoginAndPwd(String login, String pwd) {
        return users.stream().filter(u -> login.equals(u.getLogin()) && pwd.equals(u.getPassword())).findFirst();
    }

    public Optional<User> findbyLogin(String login) {
        return users.stream().filter(user -> login.equals(user.getLogin())).findAny();
    }

    public void updateUser(User user) {
        User newUser = findbyId(user.getId()).get();
        newUser=user;

    }
}
