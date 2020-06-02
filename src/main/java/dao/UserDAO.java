package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUser() throws SQLException;

    boolean addUser(String name, String telephone) throws SQLException;

    boolean editUser(User user) throws SQLException;

    boolean deleteUser(User user) throws SQLException;

    boolean searchUser(String name, String password) throws SQLException;

    public User returnUser(String name, String password) throws SQLException;

}
