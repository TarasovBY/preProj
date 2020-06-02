package service;

import dao.UserDaoFactory;
import model.User;
import util.PropertyReader;

import java.sql.SQLException;
import java.util.List;

public class Service {

    private static Service service;

    private Service() {

    }

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }
        return service;
    }


    public List<User> getAllUsers() throws SQLException {

        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).getAllUser();

    }

    public boolean addUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).addUser(user.getName(), user.getTelephone());

    }

    public boolean editUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).editUser(user);

    }

    public boolean deleteUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).deleteUser(user);

    }

    public boolean searchUser(String name, String password) throws SQLException {
        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).searchUser(name, password);
    }

    public User returnUser(String name, String password) throws SQLException {
        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).returnUser(name, password);
    }

}
