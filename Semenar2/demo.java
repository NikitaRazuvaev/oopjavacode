package Semenar2;

import java.util.List;

import Semenar2.Model.Interface.IAvtomat;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentMethod;
import Semenar2.Views.ProductView;
import Semenar2.Views.UserView;
import Semenar2.Views.Request.BasketRequest;
import Semenar2.Views.Request.PaymentRequest;
import Semenar2.Views.Request.PurshcaseRequest;
import Semenar2.Views.Request.UserRegisterRequest;

public class demo {
    public static void main(String[] args) throws Exception {
        app Application = new app();
        fillDemoData(Application);

        UserView user = Application.getUserControler().registre(registerRequest("Иван Иванов"));
        AvtomatView avtomat = Application.getAvtomatControler().getAvtomats().get(0);
        List<ProductView> products = Application.getOrderControler().getProducts(avtomat);
        Application.getOrderControler().addProduct(basketRequest(products.get(1), user));
        BasketView basket =  Application.getOrderControler().addProduct(basketRequest(products.get(2), user));
        String code = Application.getOrderControler().pay(paymentRequest(basket.totalPrice, basket, user));
        Application.getAvtomatControler().getOrderedProducts(purshcaseRequest(avtomat.id, code));
        ProductView bestProduct = Application.getAvtomatControler().getBestProduct(avtomat);

    }
    
    private static void fillDemoData(app app) throws Exception{
        IAvtomat avtomat = app.CreatAvtomat(10.0, 20.0);
        app.addProduct(avtomat, "Coco-la", 15, true);
        app.addProduct(avtomat, "Кириешки", 9, false);
        app.addProduct(avtomat, "Мороженное радуга", 6, false);
        app.addProduct(avtomat, "Вода", 10, true);
        app.addProduct(avtomat, "FrashBar", 30, false);
    }
    private static UserRegisterRequest registerRequest(String name){
        UserRegisterRequest r = new UserRegisterRequest();
        r.name = name;
        return r;
    }
    private static BasketRequest basketRequest(ProductView product, UserView user){
        BasketRequest br = new BasketRequest();
        br.product = product;
        br.user = user;
        return br;
    }
    private static PaymentRequest paymentRequest(double amount, BasketView basket, UserView user){
        PaymentRequest pr = new PaymentRequest();
        pr.amount = amount;
        pr.basket = basket;
        pr.user = user;
        pr.method = PaymentMethod.MIR;
        return pr;
    }
    private static PurshcaseRequest purshcaseRequest(int avtomatID, String code){
        PurshcaseRequest pushr = new PurshcaseRequest();
        pushr.avtomatID = avtomatID;
        pushr.code = code;
        
        return pushr;
    }
}
