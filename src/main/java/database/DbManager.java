package database;

import controller.HibernateUtil;
import entity.Hit;
import entity.HitTime;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @Singleton
    public String saveToDb(Hit hit, HitTime hitTime){
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Hit> hitsList = session.createCriteria(Hit.class).list();
            hitTime.setHit(hit);
            hit.getHitTimes().add(hitTime);
            session.save(hit);
           /* for (Hit hitFromDB : hitsList) {
                if (hit.equals(hitFromDB)) {
                    hitFromDB.getHitTimes().add(hitTime);
                    session.update(hitFromDB);
                    isSave = true;
                    break;
                }
            }
            if (!isSave){
                hit.getHitTimes().add(hitTime);
                session.save(hit);
            }*/

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
    public List<Hit> getHitsFromDb() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hit> hitsList = session.createCriteria(Hit.class).list();
        return hitsList;
    }
}
