package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * 1) сделать constrains через hibernate
 * 2) добавить еще одну сущность и сделать связь между ними
 *
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_name")
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

}

/**
 * 1) доделать код чтобы работала база
 *  2) как хибернейт использует прокси + Lazy инициализация
 *  3) CascadeType
 *  4) EJB изнутри
 */