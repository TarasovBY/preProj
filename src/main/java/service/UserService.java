package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.Connections;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService userService;

    private SessionFactory sessionFactory;


    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(Connections.getSessionFactory());
        }
        return userService;
    }

    public UserService() {

    }

    public List<User> getAllUsers() throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserJdbcDAO(connection).getAllUser();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public boolean addUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserJdbcDAO(connection).addUser(user.getName(), user.getTelephone());
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserJdbcDAO(connection).editUser(user);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserJdbcDAO(connection).deleteUser(user);
        } catch (SQLException e) {
            return false;
        }
    }

    /// тут начинается хиберней

    public List<User> getAllUsersHibernate() throws SQLException {
        try (Session session = Connections.getSessionFactory().openSession()) {
            return new UserHibernateDAO(session).getAllUser();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public boolean addUserHibernate(User user) throws SQLException {
        try (Session session = Connections.getSessionFactory().openSession()) {
            return new UserHibernateDAO(session).addUser(user.getName(), user.getTelephone());
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editUserHibernate(User user) throws SQLException {
        try (Session session = Connections.getSessionFactory().openSession()) {
            return new UserHibernateDAO(session).editUser(user);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUserHibernate(User user) throws SQLException {
        try (Session session = Connections.getSessionFactory().openSession()) {
            return new UserHibernateDAO(session).deleteUser(user);
        } catch (SQLException e) {
            return false;
        }
    }

}
