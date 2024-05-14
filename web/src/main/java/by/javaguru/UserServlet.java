package by.javaguru;

import by.javaguru.entity.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    UserService userService = UserService.getINSTANCE();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        //var user = userService.getUser(1);

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");

        writer.println("<h1> Пользователь: </h1>");
        writer.println("<p style='color:Tomato'> " + user.getName() +"</p>");
        writer.println("<p style='color:Tomato'> " + user.getAge() +"</p>");
        writer.println("<p style='color:Tomato'> " + user.getEmail() +"</p>");
        writer.println("<a href = \"update.jsp\"> Change user's details </a>");

        writer.println("</body></html>");
        writer.close();

    }
}
