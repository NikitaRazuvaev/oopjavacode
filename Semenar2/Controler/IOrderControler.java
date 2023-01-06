package Semenar2.Controler;

import java.util.List;

import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentRequest;
import Semenar2.Views.ProductView;
import Semenar2.Views.BasketRequest;

public interface IOrderControler {
    List<ProductView> getProducts(AvtomatView avtomat);
    BasketView addProduct(BasketRequest request) throws Exception;
    BasketView removeProduct(BasketRequest request) throws Exception;
    String pay(PaymentRequest request) throws Exception;
    
}
