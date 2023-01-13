package Semenar2.Model.Interface;

import java.util.Collection;

public interface IBasket {
    int getId();
    IUser getUser();
    Collection<IProduct> getProducts();
    boolean isPaid();
    String getCode();
    void setCode(String code);
    double totalPrice();
}
