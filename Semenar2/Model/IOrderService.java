package Semenar2.Model;

import java.util.Collection;

public interface IOrderService {
    Collection<IProduct> getProducts(int avtomatID);
    IBasket addProduct(int productID, int userID) ;
    IBasket removeProduct(int productID, int userID);
    String pay(int userID, double amount);
}
