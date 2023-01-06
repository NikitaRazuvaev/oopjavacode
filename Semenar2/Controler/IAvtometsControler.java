package Semenar2.Controler;


import java.util.List;


import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;

public interface IAvtometsControler {
    List<AvtomatView> getAvtomats();
    List<ProductView> getOrderedProducts(String code);
    
}
