package Semenar2.Controler;

import java.util.ArrayList;
import java.util.List;

import Semenar2.Model.IAvtomat;
import Semenar2.Model.IAvtomatRepository;
import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;

public class AvtomatControler extends ControlersBase implements IAvtometsControler {

    IAvtomatRepository avtomatRepository;
    
    public AvtomatControler (IAvtomatRepository avtoRepository) {
        this.avtomatRepository = avtoRepository;
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
    public List<ProductView> getOrderedProducts(String code) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
