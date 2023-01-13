package Semenar2.Controler.Interface;

import java.util.List;

import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.ProductView;
import Semenar2.Views.Request.BasketRequest;
import Semenar2.Views.Request.PaymentRequest;

public interface IOrderControler {
    List<ProductView> getProducts(AvtomatView avtomat);
    BasketView addProduct(BasketRequest request) throws Exception;
    BasketView removeProduct(BasketRequest request) throws Exception;
    String pay(PaymentRequest request) throws Exception;
    
}
