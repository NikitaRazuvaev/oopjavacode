package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IOrderService;
import Semenar2.Model.IProduct;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketRequest;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentRequest;
import Semenar2.Views.ProductView;

public class OrderControler extends ControlersBase implements IOrderControler {
   
    private IOrderService orderService;
    
    public OrderControler(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public List<ProductView> getProducts(AvtomatView avtomat) {
        List<ProductView> result = new ArrayList<>();
        for (IProduct product : orderService.getProducts(avtomat.id)) {
            result.add(new ProductView(product));
        }
        return result;
    }

    @Override
    public BasketView addProduct(BasketRequest request){
        return new BasketView(orderService.addProduct(request.product.id, request.user.id));
    }

    @Override
    public BasketView removeProduct(BasketRequest request) throws Exception {
    
        return new BasketView(orderService.removeProduct(request.product.id, request.user.id));
    }

    @Override
    public String pay(PaymentRequest request) throws Exception {
        return orderService.pay(request.user.id, request.amount);
    }
}
