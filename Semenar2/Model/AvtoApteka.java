package Semenar2.Model;

import Semenar2.Model.Interface.IProduct;

public class AvtoApteka extends Avtomat{

    public AvtoApteka(int id, GeoPoint point) {
        super(id, point);
    }

    @Override
    public boolean isProductApplicable(IProduct product){
        return product instanceof Drug;
    }
    
}
