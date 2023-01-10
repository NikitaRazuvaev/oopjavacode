package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IAvtomat;
import Semenar2.Model.IAvtomatService;
import Semenar2.Model.IProduct;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;
import Semenar2.Views.PurshcaseRequest;

public class AvtomatControler extends ControlersBase implements IAvtometsControler {

    private IAvtomatService avtomatService;

    public AvtomatControler(IAvtomatService avtomatService) {
        this.avtomatService = avtomatService;
    };

    @Override
    public List<AvtomatView> getAvtomats() {
        List<AvtomatView> rezult = new ArrayList<>();
        for (IAvtomat avtomat : avtomatService.getAvtomats()) {
            rezult.add(new AvtomatView(avtomat));
        }
        return rezult;
    }

    @Override
    public List<ProductView> getOrderedProducts(PurshcaseRequest request) {
        List<ProductView> result = new ArrayList<>();
        for (IProduct product : avtomatService.getOrderedProducts(request.code, request.avtomatID)) {
            result.add(new ProductView(product));
        }
        return result;

    }

    @Override
    public ProductView getBestProduct(AvtomatView avtomat) {
        return new ProductView(avtomatService.getBestProduct(avtomat.id));
    }
}
