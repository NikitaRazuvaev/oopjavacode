package Semenar2.Controler;

import java.util.List;

import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentRequest;
import Semenar2.Views.ProductView;

public class OrderControlers extends ControlersBase implements IOrderControler {
   
    private IOrderControler orderControler;

    public OrderControlers(IOrderControler controler){
        this.orderControler = controler;
    }


    @Override
    public List<ProductView> getProducts(AvtomatView avtomat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BasketView addProduct(ProductView product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BasketView removeProduct(ProductView product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String pay(PaymentRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
