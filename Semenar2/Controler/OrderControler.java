package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IBasket;
import Semenar2.Model.IBasketRepository;
import Semenar2.Model.IProduct;
import Semenar2.Model.IProductRepository;
import Semenar2.Model.IUser;
import Semenar2.Model.IUserRepository;
import Semenar2.Model.User;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.BasketRequest;
import Semenar2.Views.BasketView;
import Semenar2.Views.PaymentRequest;
import Semenar2.Views.ProductView;
import Semenar2.Views.BasketRequest;;

public class OrderControler extends ControlersBase implements IOrderControler {
   
    private IProductRepository productRepository;
    private IBasketRepository basketRepository;
    private IUserRepository userRepository;

    public OrderControler(IProductRepository productRepository, IBasketRepository basketRepository, IUserRepository userRepository){
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ProductView> getProducts(AvtomatView avtomat) {
        List<ProductView> result = new ArrayList<>();
        for (IProduct product : productRepository.getProductByAvtomatID(avtomat.id)) {
            result.add(new ProductView(product));
        }
        return result;
    }

    @Override
    public BasketView addProduct(BasketRequest request) throws Exception {
        IProduct product = productRepository.get(request.product.id);
        if (product == null){
            throw new Exception(String.format("Product not found %s",request.product.name));
        }
        
        IUser user = userRepository.get(request.user.id);
        if (user == null){
            throw new Exception(String.format("User not found %s",request.user.name));
        }
        IBasket basket = basketRepository.getOrCreateForUser(user);
        basket.getProducts().add(product);
    
        return new BasketView(basket);
    }

    @Override
    public BasketView removeProduct(BasketRequest request) throws Exception {
        IProduct product = productRepository.get(request.product.id);
        if (product == null){
            throw new Exception(String.format("Product not found %s",request.product.name));
        }
        
        IUser user = userRepository.get(request.user.id);
        if (user == null){
            throw new Exception(String.format("User not found %s",request.user.name));
        }
        IBasket basket = basketRepository.getOrCreateForUser(user);
        basket.getProducts().remove(product);
    
        return new BasketView(basket);
    }

    @Override
    public String pay(PaymentRequest request) throws Exception {
        IUser user = userRepository.get(request.user.id);
        if (user == null){
            throw new Exception(String.format("User not found %s",request.user.name));
        }
        IBasket basket = basketRepository.getOrCreateForUser(user);
        BasketView bView = new BasketView(basket);

        if (bView.totalPrice != request.amount) {
            throw new Exception(String.format("Wroeng paymod amount %f",request.amount));
        }

        String code = java.util.UUID.randomUUID().toString();
        basket.setCode(code);        
        return code;
    }
}
