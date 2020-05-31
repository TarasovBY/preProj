package servlet;

import model.User;
import service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/adduser")
public class ServletAddUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            UserService userService = UserService.getInstance();
            User user = new User(req.getParameter("name"), req.getParameter("telephone"));
            userService.addUserHibernate(user);
            resp.sendRedirect("/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
