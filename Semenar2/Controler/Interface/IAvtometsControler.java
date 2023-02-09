package Semenar2.Controler.Interface;


import java.util.List;


import Semenar2.Views.AvtomatView;
import Semenar2.Views.ProductView;
import Semenar2.Views.Request.PurshcaseRequest;

public interface IAvtometsControler {
    List<AvtomatView> getAvtomats();
    List<ProductView> getOrderedProducts(PurshcaseRequest request); // Нарушает принцип разделения интерфейса  Вынести в отдельный интерфейс (для заказов продуктов)
    ProductView getBestProduct(AvtomatView avtomat); // Нарушает принцип разделения интерфейса  Вынести в отдельный интерфейс (Аналитика продуктов)
    
}
