package by.javaguru.dao;

import by.javaguru.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class UserDao {

    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Autowired
    SessionFactory sessionFactory;

    private final String FIND_BY_LOGIN_AND_PASSWORD = """
            FROM User
            where login = :log and password = :pwd
            """;

    private final String FIND_BY_LOGIN = """
            FROM User
            where login = :log
            """;


  /*  public void addUser(User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public Optional<User> findbyId(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.beginTransaction();

            Optional<User> user = Optional.ofNullable(session.get(User.class, id));
            session.getTransaction().commit();
            return user;
        }
    }

    public List<User> showAll() {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        List<User> users = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return users;
    }*/

    public Optional<User> findbyLoginAndPwd(String login, String pwd) {
//        Session session = entityManager.unwrap(Session.class);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = null;
        Query<User> query = session.createQuery(FIND_BY_LOGIN_AND_PASSWORD, User.class);
        query.setParameter("log", login);
        query.setParameter("pwd", pwd);

        session.getTransaction().commit();
        List<User> users = query.list();
        if (!users.isEmpty()) {
            user = query.list().get(0);
        }
        return Optional.ofNullable(user);
    }

    /*public Optional<User> findbyLogin(String login) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();

        User user = null;
        Query<User> query = session.createQuery(FIND_BY_LOGIN, User.class);
        query.setParameter("log", login);

        session.getTransaction().commit();
        List<User> users = query.list();
        if (!users.isEmpty()) {
            user = query.list().get(0);
        }
        return Optional.ofNullable(user);
    }

    public void updateUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();

        session.merge(user);
        session.getTransaction().commit();
    }*/
}
