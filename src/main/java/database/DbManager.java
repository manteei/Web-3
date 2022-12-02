package database;

import controller.HibernateUtil;
import entity.Hit;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.inject.Singleton;
import java.util.List;

public class DbManager {
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Singleton
    public String saveToDb(Hit hit){
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(hit);
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
    public void cleanDb(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete FROM Hit")
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    public List<Hit> getHitsFromDb(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hit> hitsList = session.createCriteria(Hit.class).list();
        return hitsList;
    }
}
