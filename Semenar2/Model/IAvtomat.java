package Semenar2.Model;

public interface IAvtomat{
    int getId();
    GeoPoint getPoint();
    boolean isProductApplicable(IProduct product);
}
