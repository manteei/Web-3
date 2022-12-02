package controller;

import database.DbManager;
import entity.Hit;
import logic.LogicManager;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
@Data
public class HitsManager {
    private double x;
    private double y;
    private double r = 2.0;
    DbManager dbManager = new DbManager();


    public String save() { //todo создать сервис и dao
        Hit hit = new Hit();
        LogicManager logicManager = new LogicManager();
        logicManager.fillHit(hit, this.x, this.y, this.r);
        return dbManager.saveToDb(hit);
    }

    public List<Hit> getHits() {
        return dbManager.getHitsFromDb();
    }


    public void clean(){
        dbManager.cleanDb();
    }

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
}
