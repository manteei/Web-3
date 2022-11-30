public class Point {
    private double x;
    private  double y;
    private double r;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public boolean countHit(){
        return (x >= 0 && y <= 0 && x * x + y * y <= r * r) || (x <= 0 && y >= 0 && y - x <= r) || (x <= 0 && y <= 0 && x >= -r && y <= r);
    }
}
