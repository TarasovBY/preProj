package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {

    private static SessionFactory sessionFactory;

    private static Connection connection;

    private static DBHelper dbHelper;

    private DBHelper() {

    }

    public static DBHelper getInstance() {
        if(dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    public static Connection getConnectionJDBS() {
        if(connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            return DriverManager.getConnection(PropertyReader.getProperties().get("jdbsurl"));
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", PropertyReader.getProperties().get("hdialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperties().get("hcondriverclass"));
        configuration.setProperty("hibernate.connection.url", PropertyReader.getProperties().get("hconurl"));
        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperties().get("hconusername"));
        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperties().get("hconpassword"));
        configuration.setProperty("hibernate.show_sql", PropertyReader.getProperties().get("hshowsql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", PropertyReader.getProperties().get("hhbm2ddlauto"));
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
