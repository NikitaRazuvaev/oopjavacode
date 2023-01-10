package Semenar2.Model;

public class Postamat extends Avtomat {

    public Postamat(int id, GeoPoint point) {
        super(id, point);
    }
    
    @Override 
    public boolean isProductApplicable(IProduct product){
        return product instanceof Parcel;
    }
    

}
