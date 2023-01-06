package Semenar2.Controler;

import java.util.List;

import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentRequest;
import Semenar2.Views.ProductView;

public interface IOrderControler {
    List<ProductView> getProducts(AvtomatView avtomat);
    BasketView addProduct(ProductView product);
    BasketView removeProduct(ProductView product);
    String pay(PaymentRequest request);
    
}
