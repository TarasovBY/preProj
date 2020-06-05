package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory;
    private Session sessions;
    private Transaction transactions;

    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.sessions = sessionFactory.openSession();
        this.transactions = sessions.beginTransaction();
    }

    private void setSessAndTransa() {
        this.sessions = sessionFactory.openSession();
        this.transactions = sessions.beginTransaction();
    }


    public List<User> getAllUser() throws SQLException {
        setSessAndTransa();
        try (Session session = sessions) {
            return (List<User>) session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public boolean addUser(String name, String telephone) throws SQLException {
        setSessAndTransa();
        try (Session session = sessions) {
            session.save(new User(name, telephone));
            transactions.commit();
            return true;
        } catch (Exception e) {
            transactions.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean editUser(User user) throws SQLException {
        setSessAndTransa();
        try (Session session = sessions) {
            session.update(user);
            transactions.commit();
            return true;
        } catch (Exception e) {
            transactions.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(User user) throws SQLException {
        setSessAndTransa();
        try (Session session = sessions) {
            int result = session.createQuery("delete User where id = " + user.getId()).executeUpdate();
            transactions.commit();
            return result > 0;
        } catch (Exception e) {
            transactions.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchUser(String name, String password) {
        setSessAndTransa();
        try (Session session = sessions) {
            int result = session.createQuery("FROM User where name = '" + name + "'"
                    + " and password='" + password + "'").list().size();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User returnUser(String name, String password) {
        setSessAndTransa();
        try (Session session = sessions) {
            User user = (User) session.createQuery("FROM User where name = '" + name + "'"
                    + " and password='" + password + "'").list().get(0);
            return session.get(User.class, user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        }
    }
}
