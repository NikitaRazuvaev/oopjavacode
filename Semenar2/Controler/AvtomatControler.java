package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IAvtomat;
import Semenar2.Model.IAvtomatRepository;
import Semenar2.Model.IBasket;
import Semenar2.Model.IBasketRepository;
import Semenar2.Model.IProduct;
import Semenar2.Model.IProductRepository;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;
import Semenar2.Views.PurshcaseRequest;

public class AvtomatControler extends ControlersBase implements IAvtometsControler {

    private IAvtomatRepository avtomatRepository;
    private IBasketRepository basketRepository;
    private IProductRepository productRepository;


    
    public AvtomatControler (IAvtomatRepository avtoRepository, IBasketRepository basketRepository, IProductRepository productRepository) {
        this.avtomatRepository = avtoRepository;
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    };

    @Override
    public List<AvtomatView> getAvtomats() {
       List<AvtomatView> rezult = new ArrayList<>();
        for (IAvtomat avtomat : avtomatRepository.getAll()) {
            rezult.add(new AvtomatView(avtomat));
        }
        
        return rezult;
    }

    @Override
    public List<ProductView> getOrderedProducts(PurshcaseRequest request) {
        IBasket basket = basketRepository.getByCode(request.code );
        if (basket == null) {
            return null;
        }

        List<ProductView> result = new ArrayList<>();
        for (IProduct product : basket.getProducts()) {
            if (product.getLocation().getId() == request.avtomatID) {
                result.add(new ProductView(product));
            }
        }

        for (ProductView pView: result){
            IProduct temp = productRepository.get(pView.id);
            productRepository.delete(temp);
            basket.getProducts().remove(temp);
        }
        return result;

    }
}
