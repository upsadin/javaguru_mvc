package by.javaguru.entity;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String login;
    private String password;

    public User(int id, String name, int age, String email, String login, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(String name, int age, String email, String login, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
