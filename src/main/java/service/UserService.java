package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import model.User;
import util.Connections;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService userService;

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getAllUsers() throws SQLException {

        return new UserJdbcDAO(Connections.getMysqlConnection()).getAllUser();

    }

    public boolean addUser(User user) throws SQLException {

        return new UserJdbcDAO(Connections.getMysqlConnection()).addUser(user.getName(), user.getTelephone());

    }

    public boolean editUser(User user) throws SQLException {

        return new UserJdbcDAO(Connections.getMysqlConnection()).editUser(user);

    }

    public boolean deleteUser(User user) throws SQLException {

        return new UserJdbcDAO(Connections.getMysqlConnection()).deleteUser(user);

    }

    public List<User> getAllUsersHibernate() throws SQLException {

        return new UserHibernateDAO(Connections.getSessionFactory()).getAllUser();

    }

    public boolean addUserHibernate(User user) throws SQLException {

        return new UserHibernateDAO(Connections.getSessionFactory()).addUser(user.getName(), user.getTelephone());

    }

    public boolean editUserHibernate(User user) throws SQLException {

        return new UserHibernateDAO(Connections.getSessionFactory()).editUser(user);

    }

    public boolean deleteUserHibernate(User user) throws SQLException {

        return new UserHibernateDAO(Connections.getSessionFactory()).deleteUser(user);

    }

}
