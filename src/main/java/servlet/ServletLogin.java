package servlet;

import model.User;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("templates/pagelogin.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Service service = Service.getInstance();
            if (service.searchUser(req.getParameter("name"), req.getParameter("password"))) {
                User user = service.returnUser(req.getParameter("name"), req.getParameter("password"));
                HttpSession session = req.getSession();

                if (user.getRole().equals("admin")) {
                    session.setAttribute("role", user.getRole());
                    resp.sendRedirect("/admin");
                } else {
                    session.setAttribute("role", user.getRole());
                    resp.sendRedirect("/user");
                }
            } else {
                resp.sendRedirect("/login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("/login");

        }
    }
}
