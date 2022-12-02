package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time")
public class HitTime {
    @Id
    @Column
    @GenericGenerator(name="inc" , strategy="increment")
    @GeneratedValue(generator="inc")
    private int id;
    @Column
    private String currenttime;
    @Column
    private long executetime;

    @ManyToOne
    @JoinColumn(name = "hit_id")
    private Hit hit;

    public void setExecutiontime(long executiontime) {
        this.executetime = executiontime;
    }
    public long getExecutiontime() {
        return executetime;
    }
}
