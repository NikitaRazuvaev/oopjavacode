package Semenar2.Model.Interface;

public interface IProduct {
    int getId();
    String getName();
    IAvtomat getLocation();
    double getPrice();
    boolean isBestProduct();
    
}
