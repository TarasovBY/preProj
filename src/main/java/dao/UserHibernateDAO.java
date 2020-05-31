package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    public List<User> getAllUser() throws SQLException {
        Transaction transaction = session.beginTransaction();
        return (List<User>) session.createQuery("from User").list();

    }


    public boolean addUser(String name, String telephone) throws SQLException {
        Transaction transaction = session.beginTransaction();
        try {
            session.save(new User(name, telephone));
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }

    }


    public boolean editUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }

    }


    public boolean deleteUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        try {
            int result = session.createQuery("delete User where id = " + user.getId()).executeUpdate();
            transaction.commit();
            return result > 0;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }
}
