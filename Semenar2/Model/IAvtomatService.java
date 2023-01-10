package Semenar2.Model;

import java.util.Collection;

public interface IAvtomatService {
    
    Collection<IAvtomat> getAvtomats();

    Collection<IProduct> getOrderedProducts(String code, int avtomatID);

    IProduct getBestProduct(int avtomatID);

}