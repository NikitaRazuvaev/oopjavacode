package Semenar2.Model;

import java.util.Collection;

public interface IBasket {
    int getId();
    IUser getUser();
    Collection<IProduct> getProducts();
    boolean isPaid();
    String getCode();
}
