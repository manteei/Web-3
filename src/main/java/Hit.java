import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hit_checker")
public class Hit {
    @Id
    @GenericGenerator(name="inc" , strategy="increment")
    @GeneratedValue(generator="inc")
    @Column(name = "id")
    private int id;
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private double y;
    @Column(name = "r")
    private double r;
    @Column(name = "ishit")
    private boolean ishit;
    @Column(name = "currenttime")
    private String currenttime;
    @Column(name = "executetime")
    private long executetime;
    static double lastR;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setHit(boolean ishit) {
        this.ishit = ishit;
    }

    public boolean isHit() {
        return ishit;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public static double getLastR() {
        return lastR;
    }

    public static void setLastR(double lastR) {
        Hit.lastR = lastR;
    }




    public void setExecutiontime(long executiontime) {
        this.executetime = executiontime;
    }

   public long getExecutiontime() {
        return executetime;
    }

    public void setPoint(Point point) {
        this.x = point.getX();
        this.y = point.getY();
        this.r = point.getR();
    }
}