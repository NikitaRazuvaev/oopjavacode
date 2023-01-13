package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Controler.Interface.IOrderControler;
import Semenar2.Model.Interface.IProduct;
import Semenar2.Model.InterfaceService.IOrderService;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.ProductView;
import Semenar2.Views.Request.BasketRequest;
import Semenar2.Views.Request.PaymentRequest;

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
