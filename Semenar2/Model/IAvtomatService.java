package Semenar2.Model;

import java.util.Collection;

public interface IAvtomatService {
    
    public Collection<IAvtomat> getAvtomats();

    public Collection<IProduct> getOrderedProducts(String code, int avtomatID);

}