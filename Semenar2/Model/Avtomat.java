package Semenar2.Model;

public class Avtomat implements IAvtomat {
    private int id;
    private GeoPoint point;

    public Avtomat(int id, GeoPoint point){
        this.id = id;
        this.point = point;
    }

    public Avtomat(int id, IAvtomat avtomat){
        this.id = id;
        this.point = avtomat.getPoint();
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public GeoPoint getPoint() {
        return point;
    }
    
}
