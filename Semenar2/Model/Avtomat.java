package Semenar2.Model;

import Semenar2.Model.Interface.IAvtomat;
import Semenar2.Model.Interface.IProduct;

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

    @Override
    public boolean isProductApplicable(IProduct product) {
        return true;
    }
    
}
