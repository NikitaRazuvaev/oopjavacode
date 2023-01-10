package Semenar2.Model;

import java.util.ArrayList;
import java.util.Collection;

public class OrderService implements IOrderService{
    private IProductRepository productRepository;
    private IBasketRepository basketRepository;
    private IUserRepository userRepository;
    
    public OrderService(IProductRepository productRepository, UserRepository userRepository, IBasketRepository basketRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
    }

    @Override
    public Collection<IProduct> getProducts(int avtomatID) {
        Collection<IProduct> result = new ArrayList<>();
        for (IProduct product : productRepository.getAll()) {
            if (product.getLocation().getId() == avtomatID) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public IBasket addProduct(int productID, int userID) {
        IProduct product = productRepository.get(productID);
        if (product == null){
            return null;
        }
        IUser user = userRepository.get(userID);
        if (user == null){
            return null;
        }
        IBasket basket = getOrCreateForUser(user);
        basket.getProducts().add(product);
    
        return basket;
    }

    @Override
    public IBasket removeProduct(int productID, int userID){
        IProduct product = productRepository.get(productID);
        if (product == null){
            return null;
        }
        
        IUser user = userRepository.get(userID);
        if (user == null){
            return null;
        }
        IBasket basket = getOrCreateForUser(user);
        basket.getProducts().remove(product);
    
        return basket;
    }

    @Override
    public String pay(int userID, double amount) {
        IUser user = userRepository.get(userID);
        if (user == null){
           return null;
        }
        IBasket basket = getOrCreateForUser(user);
        
        if (basket.totalPrice() != amount) {
            return null;
        }

        String code = java.util.UUID.randomUUID().toString();
        basket.setCode(code);        
        return code;
    }

    private IBasket getOrCreateForUser(IUser user) {
        for (IBasket basket : basketRepository.getAll()) {
            if (basket.getUser().getId() == user.getId() && ! basket.isPaid()) {
                return basket;
            }
        }
        
        IBasket basket = new Basket(0, user, new ArrayList<IProduct>(), false, "");
        basket = basketRepository.create(basket);
        return basket;
    }

}
