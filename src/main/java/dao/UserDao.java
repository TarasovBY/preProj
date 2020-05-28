package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> allUser = new ArrayList<>();
        String sqlAllBankClient = "SELECT * FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlAllBankClient);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            allUser.add(new User(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("telephone")));
        }
        preparedStatement.close();
        resultSet.close();
        return allUser;
    }

    public boolean addUser(String name, String telephone) {

        return true;
    }

    public boolean editUser() {
        return true;
    }

    public boolean deleteUser() {
        return true;
    }


}
