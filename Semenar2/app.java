package Semenar2;

import Semenar2.Controler.AvtomatControler;
import Semenar2.Controler.IAvtometsControler;
import Semenar2.Controler.IOrderControler;
import Semenar2.Controler.IUserControler;
import Semenar2.Controler.OrderControler;
import Semenar2.Controler.UserControler;
import Semenar2.Model.Avtomat;
import Semenar2.Model.AvtomatRepository;
import Semenar2.Model.AvtomatService;
import Semenar2.Model.BasketRepository;
import Semenar2.Model.ProductRepository;
import Semenar2.Model.UserRepository;
import Semenar2.Model.UserService;
import Semenar2.Model.GeoPoint;
import Semenar2.Model.IAvtomat;
import Semenar2.Model.IAvtomatService;
import Semenar2.Model.IProduct;
import Semenar2.Model.IUserService;
import Semenar2.Model.Product;

public class app {
    private AvtomatControler avtomatControler;
    private OrderControler orderControler;
    private UserControler userControler;
    private BasketRepository basketRepository;
    private UserRepository userRepository;
    private AvtomatRepository avtomatRepository;
    private ProductRepository productRepository;

    public app(){
        userRepository = new UserRepository();
        avtomatRepository = new AvtomatRepository();
        productRepository = new ProductRepository();
        basketRepository = new BasketRepository();

        IAvtomatService avtomatService = new AvtomatService(avtomatRepository, basketRepository, productRepository);
        avtomatControler = new AvtomatControler(avtomatService);
        orderControler = new OrderControler(productRepository, basketRepository, userRepository);
        IUserService userService = new UserService(userRepository);
        userControler = new UserControler(userService);
    }

    public IAvtometsControler getAvtomatControler(){
        return avtomatControler;
    } 
    public IUserControler getUserControler(){
        return userControler;
    }
    public IOrderControler getOrderControler(){
        return orderControler;
    }

    public IAvtomat CreatAvtomat( Double longitude, Double lalitude) {
        GeoPoint point = new GeoPoint();
        point.lalitude = lalitude;
        point.longitude = longitude; 

        IAvtomat avtomat = new Avtomat(0, point);
        avtomat = avtomatRepository.create(avtomat);
        return avtomat; 
    }

    public IProduct addProduct(IAvtomat avtomat, String name, double price) throws Exception{
        IProduct product = new Product(0, name, avtomat, price);
        if (!avtomat.isProductApplicable(product)) {
            throw new Exception("This avtomat not support this product");
        }

        product = productRepository.create(product);
        return product; 
    }
    
}

