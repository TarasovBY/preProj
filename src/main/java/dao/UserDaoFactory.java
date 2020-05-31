package dao;

import util.DBHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

    public UserDAO createDAO() {

        UserDAO userDao = null;
        Properties property = new Properties();

        try {

            InputStream input = getClass().getClassLoader().getResourceAsStream(".properties");
            property.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        String properties = property.getProperty("daotype");
        switch (properties) {
            case "UserHibernateDao":
                userDao = new UserHibernateDAO(DBHelper.getSessionFactory().openSession());
                break;
            case "UserJdbcDAO":
                userDao = new UserJdbcDAO(DBHelper.getConnection());
                break;
        }

        return userDao;
    }

}
