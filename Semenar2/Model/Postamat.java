package Semenar2.Model;

import Semenar2.Model.Interface.IProduct;

public class Postamat extends Avtomat {

    public Postamat(int id, GeoPoint point) {
        super(id, point);
    }
    
    @Override 
    public boolean isProductApplicable(IProduct product){
        return product instanceof Parcel;
    }
    

}
