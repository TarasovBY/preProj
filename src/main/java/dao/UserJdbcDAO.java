package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> allUser = new ArrayList<>();
        String sqlAllBankClient = "SELECT * FROM users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAllBankClient)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allUser.add(new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("telephone")));
            }
            resultSet.close();
            return allUser;
        } catch (SQLException e) {
            return allUser;
        }


    }

    public boolean addUser(String name, String telephone) throws SQLException {
        connection.setAutoCommit(false);
        String sqlAddUser = "INSERT INTO `preproj`.`users` (`name`, `telephone`) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, telephone);
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            return false;
        }
        finally {
            connection.setAutoCommit(true);
        }
    }

    public boolean editUser(User user) throws SQLException {
        connection.setAutoCommit(false);
        String sqlEditUser = "UPDATE `preproj`.`users` SET `name` = ?, `telephone` = ? WHERE (`id` = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlEditUser)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTelephone());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            return false;
        }
        finally {
            connection.setAutoCommit(true);
        }

    }

    public boolean deleteUser(User user) throws SQLException {
        connection.setAutoCommit(false);
        String sqlDeleteUser = "DELETE FROM `preproj`.`users` WHERE (`id` = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteUser)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            return false;
        }
        finally {
            connection.setAutoCommit(true);
        }

    }


    public boolean searchUser(String name, String password) throws SQLException {
        return false;
    }


    public User returnUser(String name, String password) throws SQLException {
        return null;
    }


}
