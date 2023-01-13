package Semenar2.Model.Service;

import java.util.ArrayList;
import java.util.Collection;

import Semenar2.Model.Interface.IAvtomat;
import Semenar2.Model.Interface.IAvtomatService;
import Semenar2.Model.Interface.IBasket;
import Semenar2.Model.Interface.IProduct;
import Semenar2.Model.InterfaceRepository.IAvtomatRepository;
import Semenar2.Model.InterfaceRepository.IBasketRepository;
import Semenar2.Model.InterfaceRepository.IProductRepository;

public class AvtomatService implements IAvtomatService {

    private IAvtomatRepository avtomatRepository;
    private IBasketRepository basketRepository;
    private IProductRepository productRepository;

    public AvtomatService(IAvtomatRepository avtoRepository, IBasketRepository basketRepository,
            IProductRepository productRepository) {
        this.avtomatRepository = avtoRepository;
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Collection<IAvtomat> getAvtomats() {
        return avtomatRepository.getAll();
    }

    @Override
    public Collection<IProduct> getOrderedProducts(String code, int avtomatID) {

        IBasket basket = getBasketBycode(code);
        if (basket == null) {
            return null;
        }

        Collection<IProduct> result = new ArrayList<>();
        for (IProduct product : basket.getProducts()) {
            if (product.getLocation().getId() == avtomatID) {
                result.add(product);
            }
        }

        for (IProduct pView : result) {
            IProduct temp = productRepository.get(pView.getId());
            productRepository.delete(temp);
            basket.getProducts().remove(temp);
        }
        return result;
    }

    private IBasket getBasketBycode(String code) {
        for (IBasket basket : basketRepository.getAll()) {
            if (basket.getCode() == code) {
                return basket;
            }
        }
        return null;
    }

    @Override
    public IProduct getBestProduct(int avtomatID) {
       for (IProduct product : productRepository.getAll()) {
        if (product.getLocation().getId() == avtomatID && product.isBestProduct()) {
            return product;
        }
       } 
        return null;
    }
}
