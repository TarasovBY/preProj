package service;

import dao.UserDao;
import model.User;
import util.Connections;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {


    public UserService() {

    }

    public List<User> getAllUsers() throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserDao(connection).getAllUser();
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    public boolean addUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserDao(connection).addUser(user.getName(), user.getTelephone());
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserDao(connection).editUser(user);
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(User user) throws SQLException {
        try (Connection connection = Connections.getMysqlConnection()) {
            return new UserDao(connection).deleteUser(user);
        } catch (SQLException e) {
            return false;
        }
    }
}
