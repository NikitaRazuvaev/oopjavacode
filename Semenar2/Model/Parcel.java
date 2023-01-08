package Semenar2.Model;

public class Parcel  extends Product implements IProduct{

    public Parcel(int id, String name, IAvtomat location, double price) {
        super(id, name, location, price);
    }
    
}
