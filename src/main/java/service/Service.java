package service;

import dao.UserDaoFactory;
import model.User;

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

        return new UserDaoFactory().createDAO().getAllUser();

    }

    public boolean addUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO().addUser(user.getName(), user.getTelephone());

    }

    public boolean editUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO().editUser(user);

    }

    public boolean deleteUser(User user) throws SQLException {

        return new UserDaoFactory().createDAO().deleteUser(user);

    }

}
