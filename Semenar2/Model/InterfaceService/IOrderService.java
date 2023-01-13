package Semenar2.Model.InterfaceService;

import java.util.Collection;

import Semenar2.Model.Interface.IBasket;
import Semenar2.Model.Interface.IProduct;

public interface IOrderService {
    Collection<IProduct> getProducts(int avtomatID);
    IBasket addProduct(int productID, int userID) ;
    IBasket removeProduct(int productID, int userID);
    String pay(int userID, double amount);
}
