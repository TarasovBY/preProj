package service;

import dao.UserDAO;
import dao.UserDaoFactory;
import model.User;
import util.PropertyReader;

import java.sql.SQLException;
import java.util.List;

public class Service {

    private static Service service;
    private static UserDAO userDao;

    private Service() {

    }

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
            userDao = new UserDaoFactory().
                    createDAO(PropertyReader.getProperties());
        }
        return service;
    }




    public List<User> getAllUsers() throws SQLException {

        return new UserDaoFactory().createDAO(PropertyReader.getProperties()).getAllUser();

    }

    public boolean addUser(User user) throws SQLException {

        return userDao.addUser(user.getName(), user.getTelephone());

    }

    public boolean editUser(User user) throws SQLException {

        return userDao.editUser(user);

    }

    public boolean deleteUser(User user) throws SQLException {

        return userDao.deleteUser(user);

    }

    public boolean searchUser(String name, String password) throws SQLException {
        return userDao.searchUser(name, password);
    }

    public User returnUser(String name, String password) throws SQLException {
        return userDao.returnUser(name, password);
    }

}
