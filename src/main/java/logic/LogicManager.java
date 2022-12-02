package logic;

import entity.Hit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogicManager {
    public void fillHit(Hit hit, double x, double y, double r){
        long startTime = System.nanoTime();
        hit.setX(x);
        hit.setY(y);
        hit.setR(r);
        hit.setIshit(countHit(x, y, r));
        hit.setCurrenttime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        hit.setExecutiontime(System.nanoTime() - startTime);
        Hit.setLastR(r);
    }


    public boolean countHit(double x, double y, double r){
        return (x >= 0 && y <= 0 && x * x + y * y <= r * r) || (x <= 0 && y >= 0 && y - x <= r) || (x <= 0 && y <= 0 && x >= -r && y <= r);
    }
}
