package Semenar2.Controler;


import java.util.List;


import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;
import Semenar2.Views.PurshcaseRequest;

public interface IAvtometsControler {
    List<AvtomatView> getAvtomats();
    List<ProductView> getOrderedProducts(PurshcaseRequest request);
    
}
