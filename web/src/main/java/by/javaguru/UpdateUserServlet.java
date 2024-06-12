package by.javaguru;

import by.javaguru.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

    UserService userService = UserService.getINSTANCE();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User oldUser = (User) session.getAttribute("user");

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");

        User user = User.builder()
                .name(name)
                .age(Integer.parseInt(age))
                .email(email)
                .login(login)
                .password(pwd)
                .build();
        user.setId(oldUser.getId());
//        userService.updateUser(user);
        session.setAttribute("user", user);
        writer.println("<h1> User is updated </h1>");
        writer.println("<a href = \"/user\"> Go to user's page </a>");
    }
}
