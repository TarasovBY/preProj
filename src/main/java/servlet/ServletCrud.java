package servlet;

import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class ServletCrud extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = Service.getInstance();
        try {
            req.setAttribute("users", service.getAllUsers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("templates/pagecrud.jsp").forward(req, resp);
    }

}
