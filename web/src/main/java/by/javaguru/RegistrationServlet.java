package by.javaguru;

import by.javaguru.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    UserService userService = UserService.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");

        /*Optional<User> findUser = userService.findbyLogin(login);
        if (findUser.isPresent()) {
            writer.println("<h1> This user already exist </h1>");
        } else {
            User user = User.builder()
                    .name(name)
                    .age(Integer.parseInt(age))
                    .email(email)
                    .login(login)
                    .password(pwd)
                    .build();
            userService.addUser(user);
            writer.println("<h1> User " + name + " is added </h1>");
            writer.println("<a href = \" index.html\"> Go to the start page </a>");
        }*/
    }
}
