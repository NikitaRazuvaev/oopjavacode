package Semenar2.Controler.Interface;


import java.util.List;


import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;
import Semenar2.Views.Request.PurshcaseRequest;

public interface IAvtometsControler {
    List<AvtomatView> getAvtomats();
    List<ProductView> getOrderedProducts(PurshcaseRequest request);
    ProductView getBestProduct(AvtomatView avtomat);
    
}
