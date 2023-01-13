package Semenar2.Model.Interface;

import Semenar2.Model.GeoPoint;

public interface IAvtomat{
    int getId();
    GeoPoint getPoint();
    boolean isProductApplicable(IProduct product);
}
