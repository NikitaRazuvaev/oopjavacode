package Semenar2;

import Semenar2.Controler.AvtomatControler;
import Semenar2.Controler.OrderControler;
import Semenar2.Controler.UserControler;
import Semenar2.Controler.Interface.IAvtometsControler;
import Semenar2.Controler.Interface.IOrderControler;
import Semenar2.Controler.Interface.IUserControler;
import Semenar2.Model.Avtomat;
import Semenar2.Model.Interface.IAvtomat;
import Semenar2.Model.Interface.IAvtomatService;
import Semenar2.Model.Interface.IProduct;
import Semenar2.Model.InterfaceService.IOrderService;
import Semenar2.Model.InterfaceService.IUserService;
import Semenar2.Model.Repository.AvtomatRepository;
import Semenar2.Model.Repository.BasketRepository;
import Semenar2.Model.Repository.ProductRepository;
import Semenar2.Model.Repository.UserRepository;
import Semenar2.Model.Service.AvtomatService;
import Semenar2.Model.Service.OrderService;
import Semenar2.Model.Service.UserService;
import Semenar2.Model.GeoPoint;
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
        IOrderService orderService = new OrderService(productRepository, userRepository, basketRepository);
        orderControler = new OrderControler(orderService);
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

    public IProduct addProduct(IAvtomat avtomat, String name, double price, boolean isBest) throws Exception{
        IProduct product = new Product(0, name, avtomat, price, isBest);
        if (!avtomat.isProductApplicable(product)) {
            throw new Exception("This avtomat not support this product");
        }

        product = productRepository.create(product);
        return product; 
    }
    
}

