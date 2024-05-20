package by.javaguru.dao;

import by.javaguru.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UserDao {
    private final String FIND_BY_ID = """
            SELECT * FROM users
            where id = ?;
            """;

    private final String FIND_BY_LOGIN_AND_PASSWORD = """
            SELECT * FROM users
            where login = ? and password = ?;
            """;

    private final String FIND_BY_LOGIN = """
            SELECT * FROM users
            where login = ?;
            """;

    private final String ADD_USER = """
            INSERT INTO USERS(name, age, email, login, password)
            VALUES(?, ?, ?, ?, ?);""";

    private final String UPDATE_USER = """
            UPDATE USERS SET 
            name = ?, age = ?, email = ?, login = ?, password = ?            
            WHERE id = ?;""";

    private final String FIND_ALL = """
            SELECT * FROM users;
            """;

    public void addUser(User user) {
        try (PreparedStatement statement = BaseConnector.open().prepareStatement(ADD_USER,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                user.setId(id);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<User> findbyId(int id) {
        User user = new User();
           try (PreparedStatement statement = BaseConnector.open().prepareStatement(FIND_BY_ID)) {
               statement.setInt(1, id);
               statement.executeQuery();
               ResultSet resultSet = statement.getResultSet();

               user = generateFromresultSet(resultSet);

           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
        return Optional.ofNullable(user);
    }

    public List<User> showAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = BaseConnector.open().prepareStatement(FIND_ALL)) {
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                users.add(generateFromresultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public Optional<User> findbyLoginAndPwd(String login, String pwd) {
        User user = null;
        try (PreparedStatement statement = BaseConnector.open()
                .prepareStatement(FIND_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, pwd);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                user = generateFromresultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    public Optional<User> findbyLogin(String login) {
        User user = null;
        try (PreparedStatement statement = BaseConnector.open().prepareStatement(FIND_BY_LOGIN)) {
            statement.setString(1, login);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                user = generateFromresultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    public void updateUser(User user) {
        try (PreparedStatement statement = BaseConnector.open().prepareStatement(UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static User generateFromresultSet(ResultSet resultSet) {
        User user = null;
        try {
                user = new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getString("email"),
                resultSet.getString("login"),
                resultSet.getString("password")
                );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
