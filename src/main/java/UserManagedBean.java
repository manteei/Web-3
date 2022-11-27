import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.List;

import lombok.Data;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
@Data
public class UserManagedBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    private String name;
    private String surname;
    private String message;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMessage() {
        StringBuffer strBuff = new StringBuffer();
        strBuff.append("Name : ").append(this.getName());
        strBuff.append(", Surname : ").append(this.getSurname());
        this.setMessage(strBuff.toString());
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String save() {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = new User();
        user.setName(this.getName());
        user.setSurname(this.getSurname());
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            result = SUCCESS;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                result = ERROR;
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public List<User> getUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User>  userList = session.createCriteria(User.class).list();
        return userList;
    }

    public void reset() {
        this.setName("");
        this.setSurname("");
    }
}