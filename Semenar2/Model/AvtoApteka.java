package Semenar2.Model;

public class AvtoApteka extends Avtomat{

    public AvtoApteka(int id, GeoPoint point) {
        super(id, point);
    }

    @Override
    public boolean isProductApplicable(IProduct product){
        return product instanceof Drug;
    }
    
}
