package by.javaguru;

import by.javaguru.entity.User;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {

    UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        session.setAttribute("userService", userService);
        String login = req.getParameter("login");
        String pwd = req.getParameter("pwd");
        session.setAttribute("login", login);
        session.setAttribute("pwd", pwd);
        Optional<User> user = userService.findbyLoginAndPwd(login, pwd);
        if(user.isEmpty()) {
            var writer = resp.getWriter();
            writer.println("<h1> User is not exist </h1");
        } else {
            resp.sendRedirect("menu.html");
        }
    }
}
