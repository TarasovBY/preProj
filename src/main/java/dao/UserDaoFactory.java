package dao;

import util.DBHelper;

import java.util.HashMap;
import java.util.Map;


public class UserDaoFactory {

    public UserDAO createDAO(Map<String, String> properties) {

        UserDAO userDao = null;

        switch (properties.get("daoype")) {
            case "UserHibernateDao":
                userDao = new UserHibernateDAO(DBHelper.getSessionFactory());
                break;
            case "UserJdbcDAO":
                userDao = new UserJdbcDAO(DBHelper.getConnectionJDBS());
                break;
        }

        return userDao;
    }

}
