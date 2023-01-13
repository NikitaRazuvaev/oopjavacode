package Semenar2.Model;

import Semenar2.Model.Interface.IAvtomat;

public class Drug extends Product {

    public Drug(int id, String name, IAvtomat location, double price, boolean isbest) {
        super(id, name, location, price, isbest);
    }

   
}
