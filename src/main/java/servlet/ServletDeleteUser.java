package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteuser")
public class ServletDeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            UserService userService = UserService.getInstance();
            User user = new User(Integer.parseInt(req.getParameter("id")),
                    req.getParameter("name"),
                    req.getParameter("telephone"));
            userService.deleteUserHibernate(user);
            resp.sendRedirect("/");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
