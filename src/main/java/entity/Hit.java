package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "hits")
public class Hit {
    @Id
    @GenericGenerator(name="inc" , strategy="increment")
    @GeneratedValue(generator="inc")
    private int id;
    @Column
    private double x;
    @Column
    private double y;
    @Column
    private double r;
    @Column
    private boolean ishit;

    @OneToMany(mappedBy="hit", cascade=CascadeType.ALL)
    private List<HitTime> hitTimes = new ArrayList<>();

    static double lastR;

    public static double getLastR() {
        return lastR;
    }
    public static void setLastR(double lastR) {
        Hit.lastR = lastR;
    }

    public void setHitTimes(List<HitTime> hitTimes) {
        this.hitTimes = hitTimes;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Hit)) return false;
        Hit hit = (Hit) obj;
        return (this.x ==(hit.x))&&(this.y==(hit.y))&&(this.r==(hit.r));
    }


}

/**
 * 1) доделать код чтобы работала база
 *  2) как хибернейт использует прокси + Lazy инициализация
 *  3) CascadeType
 *  4) EJB изнутри
 */