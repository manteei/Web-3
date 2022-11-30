import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.Data;
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
    private double x;
    private double y;
    private double r = 2.0;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String save() {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        long startTime = System.nanoTime();
        Point point = new Point();
        point.setX(this.getX());
        point.setY(this.getY());
        point.setR(this.getR());
        Hit hit = new Hit();
        hit.setPoint(point);
        hit.setIshit(point.countHit());
        hit.setCurrenttime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        hit.setExecutiontime(System.nanoTime() - startTime);
        Hit.setLastR(this.getR());

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

    public List<Hit> getHits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Hit>  hitsList = session.createCriteria(Hit.class).list();
        return hitsList;
    }
   /* public double getLastR(List<Hit>  hitsList){
        hitsList.toArray();
        Hit hit = hitsList.get(hitsList.size()-1);
        return hit.getR();

    }*/

    public void clean(){
        Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.createQuery("delete FROM Hit")
                        .executeUpdate();
                session.getTransaction().commit();
                session.close();
    }
}
