package Semenar2.Model;

import Semenar2.Model.Interface.IAvtomat;

public class Parcel  extends Product{

    public Parcel(int id, String name, IAvtomat location, double price, boolean isbest) {
        super(id, name, location, price, isbest);
    }

    
    
}
